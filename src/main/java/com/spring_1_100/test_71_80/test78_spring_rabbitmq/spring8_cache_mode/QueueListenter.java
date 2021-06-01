package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring8_cache_mode;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author xuexiaolei
 * @version 2017年08月22日
 */

public class QueueListenter implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("---------------------" + message);
    }
}