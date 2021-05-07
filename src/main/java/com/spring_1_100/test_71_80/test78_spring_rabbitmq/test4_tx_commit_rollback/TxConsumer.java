package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test4_tx_commit_rollback;

import com.rabbitmq.client.*;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

import java.io.IOException;

public class TxConsumer {

    private static final String QUEUE_NAME = "test_queue_tx";

    public static void main(String[] args) throws Exception {

        //1 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2 设置参数
        connectionFactory.setHost(RabbitConstant.HOST);//设置注解
        connectionFactory.setPort(RabbitConstant.PORT);//设置端口
        connectionFactory.setVirtualHost(RabbitConstant.VHOST);//设置虚拟及
        connectionFactory.setUsername(RabbitConstant.USERNAME);
        connectionFactory.setPassword(RabbitConstant.PASSWORD);

        // 3 创建Channel
        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        DefaultConsumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String msg = new String(body, "utf-8");
                System.out.println("consumer: " + msg);
            }
        };

        //监听
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}