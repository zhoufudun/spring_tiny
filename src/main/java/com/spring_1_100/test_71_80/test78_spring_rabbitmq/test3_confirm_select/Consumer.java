package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test3_confirm_select;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private static String queueName = "test";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //1 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2 设置参数
        connectionFactory.setHost(RabbitConstant.HOST);//设置注解
        connectionFactory.setPort(RabbitConstant.PORT);//设置端口
        connectionFactory.setVirtualHost(RabbitConstant.VHOST);//设置虚拟及
        connectionFactory.setUsername(RabbitConstant.USERNAME);
        connectionFactory.setPassword(RabbitConstant.PASSWORD);

        // 3 创建Channel
        Connection  connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        // 4 创建Queue
        channel.queueDeclare(queueName , true , false , false , null);

        // 5 创建消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName , true , consumer);

        // 6 接收消息
        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.out.println(msg);
        }
    }
}
