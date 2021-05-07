package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test10_exclusive;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

import java.io.IOException;

public class Producer {

    private final static String QUEUE_NAME = "UserLogin2";
    private final static String EXCHANGE_NAME = "user.login";

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            //1 创建连接工厂
            ConnectionFactory connectionFactory = new ConnectionFactory();
            //2 设置参数
            connectionFactory.setHost(RabbitConstant.HOST);//设置注解
            connectionFactory.setPort(RabbitConstant.PORT);//设置端口
            connectionFactory.setVirtualHost(RabbitConstant.VHOST);//设置虚拟及
            connectionFactory.setUsername(RabbitConstant.USERNAME);
            connectionFactory.setPassword(RabbitConstant.PASSWORD);

            // 3 创建Channel
            Connection conn = connectionFactory.newConnection();
            Channel channel = conn.createChannel();


            AMQP.Queue.DeclareOk declareOk = channel.queueDeclare(QUEUE_NAME, true, true, false, null);

            channel.basicPublish("", QUEUE_NAME, null, "Hello".getBytes());

            //close the channel, check if the queue is deleted
            System.out.println("Try to close channel");
            channel.close();
            System.out.println("Channel closed");

            System.out.println("Create a new channel");
            Channel channel2 = conn.createChannel();
            AMQP.Queue.DeclareOk declareOk2 = channel2.queueDeclarePassive(QUEUE_NAME);

            //we can access the exclusive queue from another channel
            System.out.println(declareOk2.getQueue()); //will output "UserLogin2"
            channel2.basicPublish("", QUEUE_NAME, null, "Hello2".getBytes());
            System.out.println("Message published through the new channel");

//            System.out.println("Try to close Connection");
//            conn.close();
//            System.out.println("Connection closed");


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}