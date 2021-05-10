package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test13_exclusive;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class Producer {

    public static void main(String[] args) throws IOException, Exception {

        //1 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2 设置参数, uri为amqp://userName:password@ipAddress:portNumber/virtualHost
        connectionFactory.setUri("amqp://guest:guest@172.16.157.242:5672");
        //3 创建连接
        Connection connection1 = connectionFactory.newConnection();
        //4 创建channel
        Channel channel = connection1.createChannel();
        channel.queueDeclare("hello_world5", false, true, false, null);

        Connection connection2 = connectionFactory.newConnection();
        //4 创建channel
        Channel channel2 = connection2.createChannel();
        channel2.queueDeclare("hello_world5", false, false, false, null);

        //7 释放连接资源
        channel.close();
        connection1.close();
        connection2.close();
    }
}
