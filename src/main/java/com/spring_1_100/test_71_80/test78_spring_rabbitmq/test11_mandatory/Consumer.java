package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test11_mandatory;

import com.rabbitmq.client.*;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.test8_reject.Producer;

import java.io.IOException;

public class Consumer {

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
         * autoDelete:   当没有consumer时候是否删除队列
         * arguments：配置的基本参数
         */
        channel.exchangeDeclare("mandatory-test", BuiltinExchangeType.DIRECT);
        channel.queueDeclare("hello_world",true,false,false,null);
        channel.queueBind("hello_world", "mandatory-test", "xaxa");
        //6 从消息队列中消费
        /**参数介绍：
         *basicConsume(String queue, boolean autoAck, Consumer callback)
         * queue: 消费的队列名称
         * autoAck：是否自动消费确认，收到消息确认
         * callback：回调对象
         */
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel){
            //这是一个回调方法，当收到消息后会自动执行该方法
            /**
             * @param consumerTag ：标识
             * @param envelope： 获取交换机，路由等信息
             * @param properties：配置信息
             * @param body：真是的数据
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(""+consumerTag);
                System.out.println("getExchange+"+envelope.getExchange());
                System.out.println("getRoutingKey+"+envelope.getRoutingKey());
                System.out.println("properties"+properties);
                System.out.println("body"+new String(body,"utf-8"));
            }
        };
        channel.basicConsume("hello_world",true,consumer);
        //7 消费者不关闭连接
    }
}