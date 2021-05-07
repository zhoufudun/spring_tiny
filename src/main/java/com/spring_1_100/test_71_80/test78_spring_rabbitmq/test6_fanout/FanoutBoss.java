package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test6_fanout;

import com.rabbitmq.client.*;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
//广播模式-消息生产者
public class FanoutBoss {
    private static final Logger logger = Logger.getLogger(FanoutBoss.class);
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
            //3 创建连接
            Connection connection = null;
            connection = connectionFactory.newConnection();
            //4 创建channel
            Channel channel = null;
            channel = connection.createChannel();
            String message = "当前时间为：2018年8月6日14:25:14";
            //声明交换机（参数为：交换机名称; 交换机类型，广播模式）
            channel.exchangeDeclare("fanoutLogs", BuiltinExchangeType.FANOUT);
            //消息发布（参数为：交换机名称; routingKey，忽略。在广播模式中，生产者声明交换机的名称和类型即可）
            channel.basicPublish("fanoutLogs","", null,message.getBytes());
            logger.info("********Message********:发送成功");
            channel.close();
            connection.close();
        } catch (IOException |TimeoutException e) {
            e.printStackTrace();
        }
   }
}