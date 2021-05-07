package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test7_topic;

import com.rabbitmq.client.*;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

import java.io.IOException;

public class LogConsumer2 {



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

        channel.queueDeclare("log-queue", false, false, true, null);
        channel.queueBind("log-queue", "topic-exchange", "*.log");


        channel.basicConsume("log-queue", new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("[log] body:" + new String(body));
                //发送确认消息
                channel.basicAck(envelope.getDeliveryTag(), true);
            }
        });
        Thread.sleep(Integer.MAX_VALUE);
    }
}
