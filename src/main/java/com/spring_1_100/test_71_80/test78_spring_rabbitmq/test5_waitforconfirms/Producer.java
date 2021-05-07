package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test5_waitforconfirms;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

import java.io.IOException;

public class Producer {

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
        Connection connection = null;
        connection = connectionFactory.newConnection();
        //4 创建channel
        Channel channel = null;
        channel = connection.createChannel();
        //5 创建队列Queen
        /**参数介绍：
         * queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
         * queue：队列名称   durable：是否持久化   exclusive是否独占，只能有一个消费者监听队列。         * queue：队列名称   durable：是否持久化   exclusive是否独占，只能有一个消费者监听队列。
         * autoDelete:   当没有consumer时候是否删除队列     arguments：配置的基本参数
         */
        channel.queueDeclare("hello_world", true, false, false, null);
        //6 发送消息到队列
        /**参数介绍：
         * basicPublish(String exchange, String routingKey, boolean mandatory, BasicProperties props, byte[] body)
         *exchange： 交换机的名称，简单模式下交换机会使用默认的    routingKey：路由名称,如果使用默认交换机要和队列名相同
         *props 配置信息    body：真是发送的消息数据
         */
        String constant = "大家好这是在测试";
        channel.confirmSelect();
        for(int i = 0 ;i < 3;i ++){
            String body = constant + i;
            channel.basicPublish("", "hello_world", null, body.getBytes());
        }

        if(!channel.waitForConfirms()){
            System.out.println("send message failed.");
        }

        //7 释放连接资源
        channel.close();
        connection.close();
    }
}
