package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring3_mandatory_expression;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class MQReturnListener implements RabbitTemplate.ReturnCallback {

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("message = " + JSON.toJSONString(message));
        System.out.println("replyCode = " + replyCode + ",replyText="+replyText + ",exchange="+exchange + ",routingKey="+routingKey);
    }
}
