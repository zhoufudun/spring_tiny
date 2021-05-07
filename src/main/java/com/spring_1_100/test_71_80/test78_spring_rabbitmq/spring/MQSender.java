package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuexiaolei
 * @version 2017年08月22日
 */

public class MQSender {

    public static final String queue_key = "test_queue_key";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring78_rabbitmq/spring78_mq_sender.xml");
        Map<String, Object> msg = new HashMap();
        msg.put("data", "hello,rabbmitmq!");
        msg.put("time", System.currentTimeMillis());
        System.out.println("++++++++++++++++++++" + JSON.toJSONString(msg));
        RabbitTemplate rabbitTemplate = (RabbitTemplate) context.getBean("rabbitTemplate");
        rabbitTemplate.convertAndSend(queue_key, msg);
    }

}