package com.ay.mq;

import com.ay.dto.MoodDTO;
import com.ay.model.Mood;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 消费者
 *
 * @author Ay
 * @date 2017/11/30
 */
@Component
public class MoodConsumer implements MessageListener {

    private static final String PRAISE_HASH_KEY = "springmv.mybatis.boot.mood.id.list.key";

    @Resource
    private RedisTemplate redisTemplate;

    private Logger log = Logger.getLogger(this.getClass());

    public void onMessage(Message message) {
        try {
            MoodDTO mood = (MoodDTO) ((ActiveMQObjectMessage) message).getObject();
            //1.存放到set中
            redisTemplate.opsForSet().add(PRAISE_HASH_KEY, mood.getId());
            //2.存放到set中
            redisTemplate.opsForSet().add(mood.getId(), mood.getUserId());
            log.info("消费者--->>>用户id：" + mood.getUserId() + " 给说说id：" + mood.getId() + " 点赞");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
