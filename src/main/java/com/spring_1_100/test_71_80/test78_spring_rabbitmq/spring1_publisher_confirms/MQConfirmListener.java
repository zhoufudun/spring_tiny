package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring1_publisher_confirms;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

public class MQConfirmListener implements RabbitTemplate.ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {

            System.out.println("--------消息没有被确认---------" + ack + " ,case " + cause);
            // 处理ack
        } else {
            // 处理nack, 此时cause包含nack的原因。
            // 如当发送消息给一个不存在的Exchange。这种情况Broker会关闭Channel；
            // 当Broker关闭或发生网络故障时，需要重新发送消息。
            // 暂时先日志记录，包括correlationData, cause等。

            System.out.println("+++++++++++++++++" + ack + " ,case " + cause);
        }

    }
}
