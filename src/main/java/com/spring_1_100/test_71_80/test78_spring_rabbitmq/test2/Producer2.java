package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test2;

import com.rabbitmq.client.*;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Producer2 {

    public static void main(String[] args) throws IOException, Exception {

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
        //5 创建队列Queen
        /**参数介绍：
         * queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
         * queue：队列名称   durable：是否持久化   exclusive是否独占，只能有一个消费者监听队列。
         * * queue：队列名称   durable：是否持久化   exclusive是否独占，只能有一个消费者监听队列。
         * autoDelete:   当没有consumer时候是否删除队列     arguments：配置的基本参数
         */
        channel.exchangeDeclare("hello-exchange",
                BuiltinExchangeType.DIRECT,
                true,
                false,
                false,null);

        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put("my1", "1111");
        headers.put("my2", "2222");

        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .deliveryMode(2) // 传送方式
                .contentEncoding("UTF-8") // 编码方式
                .expiration("10000") // 过期时间
                .headers(headers) //自定义属性
                .build();
        channel.basicPublish("hello-exchange","hola", properties,"odsidios".getBytes());
        //7 释放连接资源
        channel.close();
        connection.close();
    }
}
