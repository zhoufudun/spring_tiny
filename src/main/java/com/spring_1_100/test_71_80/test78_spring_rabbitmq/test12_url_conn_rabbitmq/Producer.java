package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test12_url_conn_rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

import java.io.IOException;

public class Producer {

    public static void main(String[] args) throws IOException, Exception {

        //1 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2 设置参数, uri为amqp://userName:password@ipAddress:portNumber/virtualHost
        //【注意】当virtualHost为 / 时
        // amqp://guest:guest@localhost:5672/ 这样写会导致:
        // Caused by: com.rabbitmq.client.ShutdownSignalException: connection error; protocol method: #method<connection.close>(reply-code=530,
        // reply-text=NOT_ALLOWED - access to vhost '' refused for user 'guest', class-id=10, method-id=40)
        // 或
        // amqp://guest:guest@localhost:5672// 这
        // Exception in thread "main" java.lang.IllegalArgumentException: Multiple segments in path of AMQP URI: //
        // 写者会抛出异常
        connectionFactory.setUri("amqp://guest:guest@172.16.157.242:5672//");
        //3 创建连接
        Connection connection = connectionFactory.newConnection();
        //4 创建channel
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("producer-customer-test", BuiltinExchangeType.DIRECT, true);
        //5 创建队列Queen
        /**参数介绍：
         * queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
         * queue：队列名称   durable：是否持久化   exclusive是否独占，只能有一个消费者监听队列。         * queue：队列名称   durable：是否持久化   exclusive是否独占，只能有一个消费者监听队列。
         * autoDelete:   当没有consumer时候是否删除队列     arguments：配置的基本参数
         */
        channel.queueDeclare("hello_world", true, false, false, null);
        channel.queueBind("hello_world", "producer-customer-test", "routing_key_1");

        String constant = "大家好这是在测试";
        for (int i = 0; i < 3; i++) {
            String body = constant + i;
            channel.basicPublish("producer-customer-test", "routing_key_1", null, body.getBytes());
        }

        String exchangeName = "9oidsoi";
        String routingKey = "893982w";

/*
        channel.exchangeDeclare(exchangeName,"direct",true);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName,exchangeName,routingKey);*/

        //7 释放连接资源
        channel.close();
        connection.close();
    }
}
