package com.ay.mq;

import com.ay.dto.MoodDTO;
import com.ay.model.Mood;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * 生产者jmsTemplate
 *
 * @author Ay
 * @date 2017/11/30
 */
@Component
public class MoodProducer {

    @Resource
    private JmsTemplate jmsTemplate;

    private Logger log = Logger.getLogger(this.getClass());

    public void sendMessage(Destination destination, final MoodDTO mood) {
        log.info("生产者--->>>用户id：" + mood.getUserId() + " 给说说id：" + mood.getId() + " 点赞");
        //mood实体需要实现Serializable序列化接口
        jmsTemplate.convertAndSend(destination, mood);
    }
}
