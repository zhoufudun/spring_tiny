package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring2_publisher_returns;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

public class MQReturnListener implements RabbitTemplate.ReturnCallback {

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("message = " + message);
        System.out.println("replyCode = " + replyCode + ",replyText="+replyText + ",exchange="+exchange + ",routingKey="+routingKey);
    }
}
