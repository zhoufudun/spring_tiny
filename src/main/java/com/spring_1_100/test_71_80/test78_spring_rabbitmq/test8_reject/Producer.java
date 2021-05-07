package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test8_reject;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消息消费的拒绝
 */
public class Producer {

    public final static String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
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

        //在信道中设置交换器(这里选择直接交换器direct)
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        //在消费者中申明队列

        //申明路由键及消息体
        for (int i = 0; i < 10; i++) {
            String route = "error";
            String msg = "Hello World" + (i + 1);
            //发布消息(设置交换器、路由键、参数、消息内容)
            channel.basicPublish(EXCHANGE_NAME, route, null, msg.getBytes());
            System.out.println("Send:" + route + ";" + msg);
        }
        //关闭信道
        channel.close();
        //关闭连接
        connection.close();
    }
}
