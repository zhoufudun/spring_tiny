package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test7_topic;

import com.rabbitmq.client.*;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

public class LogProducer {

    public static void main(String[] args) throws Exception {


        //1 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2 设置参数
        connectionFactory.setHost(RabbitConstant.HOST);//设置注解
        connectionFactory.setPort(RabbitConstant.PORT);//设置端口
        connectionFactory.setVirtualHost(RabbitConstant.VHOST);//设置虚拟及
        connectionFactory.setUsername(RabbitConstant.USERNAME);
        connectionFactory.setPassword(RabbitConstant.PASSWORD);
        //3 创建连接
        Connection connection = connectionFactory.newConnection();
        //4 创建channel
        Channel channel = connection.createChannel();
        String message = "hello";

        channel.exchangeDeclare("topic-exchange", BuiltinExchangeType.TOPIC, true);
        channel.basicPublish("topic-exchange", "error.log", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        Thread.sleep(Integer.MAX_VALUE);
    }
}
