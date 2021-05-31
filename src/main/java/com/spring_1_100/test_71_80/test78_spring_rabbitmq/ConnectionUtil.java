package com.spring_1_100.test_71_80.test78_spring_rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtil {

    public static Connection getConnection (){
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
            return  connectionFactory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}
