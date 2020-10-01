package com.ay.job;

import com.ay.model.Mood;
import com.ay.model.UserMoodPraiseRel;
import com.ay.service.MoodService;
import com.ay.service.UserMoodPraiseRelService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 描述：定时器
 *
 * @author Ay
 * @date 2018/1/6.
 */
@Component
@Configurable
@EnableScheduling
public class PraiseDataSaveDBJob {

    //每5秒执行一次
    @Scheduled(cron = "*/60 * *  * * * ")
    public void savePraiseDataToDB() {
        System.out.println("run .....");
    }

    @Resource
    private RedisTemplate redisTemplate;
    private static final String PRAISE_HASH_KEY = "springmv.mybatis.boot.mood.id.list.key";
    @Resource
    private UserMoodPraiseRelService userMoodPraiseRelService;
    @Resource
    private MoodService moodService;

    //每10秒执行一次，真实项目当中，我们可以把定时器的执行计划时间设置长一点
    //比如说每天晚上凌晨2点跑一次。
    @Scheduled(cron = "*/10 * *  * * * ")
    public void savePraiseDataToDB2() {

        //获取所有被点赞的说说id
        Set<String> moods = redisTemplate.opsForSet().members(PRAISE_HASH_KEY);
        if (CollectionUtils.isEmpty(moods)) {
            return;
        }
        for (String moodId : moods) {
            if (redisTemplate.opsForSet().members(moodId) == null) {
                continue;
            } else {
                //通过说说id获取所有点赞的用户id列表
                Set<String> userIds = redisTemplate.opsForSet().members(moodId);
                if (CollectionUtils.isEmpty(userIds)) {
                    continue;
                } else {
                    for (String userId : userIds) {
                        UserMoodPraiseRel userMoodPraiseRel = new UserMoodPraiseRel();
                        userMoodPraiseRel.setMoodId(moodId);
                        userMoodPraiseRel.setUserId(userId);
                        //保存说说与用户关联关系
                        userMoodPraiseRelService.save(userMoodPraiseRel);
                    }
                    Mood mood = moodService.findById(moodId);
                    //更新说说点赞数量
                    //说说的总点赞数量 = redis 点赞数量 + 数据库的点赞数量
                    mood.setPraiseNum(mood.getPraiseNum() + redisTemplate.opsForSet().size(moodId).intValue());
                    moodService.update(mood);
                    //清除缓存数据
                    redisTemplate.delete(moodId);
                }
            }
        }
        //清除缓存数据
        redisTemplate.delete(PRAISE_HASH_KEY);

    }
}