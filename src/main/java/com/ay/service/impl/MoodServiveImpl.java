package com.ay.service.impl;

import com.ay.dao.MoodDao;
import com.ay.dao.UserDao;
import com.ay.dao.UserMoodPraiseRelDao;
import com.ay.dto.MoodDTO;
import com.ay.model.Mood;
import com.ay.model.User;
import com.ay.model.UserMoodPraiseRel;
import com.ay.mq.MoodProducer;
import com.ay.service.MoodService;
import com.ay.service.UserService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述：说说服务类
 *
 * @author Ay
 * @date 2018/1/6.
 */
@Service
public class MoodServiveImpl implements MoodService {
    @Resource
    private MoodDao moodDao;
    @Resource
    private UserDao userDao;
    @Resource
    private UserMoodPraiseRelDao userMoodPraiseRelDao;

    @Resource
    private MoodProducer moodProducer;

    //队列
    private static Destination destination = new ActiveMQQueue("ay.queue.high.concurrency.praise");


    public boolean praiseMoodForRedis(String userId, String moodId) {
        MoodDTO moodDTO = new MoodDTO();
        moodDTO.setUserId(userId);
        moodDTO.setId(moodId);
        moodProducer.sendMessage(destination, moodDTO);

//        //1.存放到hashset中
//        redisTemplate.opsForSet().add(PRAISE_HASH_KEY , moodId);
//        //2.存放到set中
//        redisTemplate.opsForSet().add(moodId,userId);
        return false;
    }

    public List<MoodDTO> findAll() {
        List<Mood> moodList = moodDao.findAll();
        return converModel2DTO(moodList);
    }

    private List<MoodDTO> converModel2DTO(List<Mood> moodList) {
        if (CollectionUtils.isEmpty(moodList)) return Collections.EMPTY_LIST;
        List<MoodDTO> moodDTOList = new ArrayList<MoodDTO>();
        for (Mood mood : moodList) {
            MoodDTO moodDTO = new MoodDTO();
            moodDTO.setId(mood.getId());
            moodDTO.setContent(mood.getContent());
            moodDTO.setPraiseNum(mood.getPraiseNum());
            moodDTO.setPublishTime(mood.getPublishTime());
            moodDTO.setUserId(mood.getUserId());
            moodDTOList.add(moodDTO);
            //设置用户信息
            User user = userDao.find(mood.getUserId());
            moodDTO.setUserName(user.getName());
            moodDTO.setUserAccount(user.getAccount());
        }
        return moodDTOList;
    }

    public boolean praiseMood(String userId, String moodId) {
        //保存关联关系
        UserMoodPraiseRel userMoodPraiseRel = new UserMoodPraiseRel();
        userMoodPraiseRel.setUserId(userId);
        userMoodPraiseRel.setMoodId(moodId);
        userMoodPraiseRelDao.save(userMoodPraiseRel);
        //更新说说的点赞数量
        Mood mood = this.findById(moodId);
        mood.setPraiseNum(mood.getPraiseNum() + 1);
        this.update(mood);

        return Boolean.TRUE;
    }

    public boolean update(Mood mood) {
        return moodDao.update(mood);
    }

    public Mood findById(String id) {
        return moodDao.findById(id);
    }

    @Resource
    private RedisTemplate redisTemplate;

    private static final String PRAISE_HASH_KEY = "springmv.mybatis.boot.mood.id.list.key";


    @Resource
    private UserService userService;

    public List<MoodDTO> findAllForRedis() {
        List<Mood> moodList = moodDao.findAll();
        if (CollectionUtils.isEmpty(moodList)) {
            return Collections.EMPTY_LIST;
        }
        List<MoodDTO> moodDTOList = new ArrayList<MoodDTO>();
        for (Mood mood : moodList) {
            MoodDTO moodDTO = new MoodDTO();
            moodDTO.setId(mood.getId());
            moodDTO.setUserId(mood.getUserId());
            //right = 总点赞数量 ： 数据库的点赞数量 + redis的点赞数量
            moodDTO.setPraiseNum(mood.getPraiseNum() + redisTemplate.opsForSet().size(mood.getId()).intValue());
            moodDTO.setPublishTime(mood.getPublishTime());
            moodDTO.setContent(mood.getContent());
            //通过userID查询用户
            User user = userService.find(mood.getUserId());
            //用户名
            moodDTO.setUserName(user.getName());
            //账户
            moodDTO.setUserAccount(user.getAccount());
            moodDTOList.add(moodDTO);
        }
        return moodDTOList;
    }
}
