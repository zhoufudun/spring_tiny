package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test6_fanout;

import com.rabbitmq.client.*;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

//广播模式-消息消费者
public class FanoutWorker2 {

    private static final Logger logger = Logger.getLogger(FanoutWorker2.class);
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
            //交换机声明（参数为：交换机名称；交换机类型）
            channel.exchangeDeclare("fanoutLogs",BuiltinExchangeType.FANOUT);
            //获取一个临时队列
            String queueName = channel.queueDeclare().getQueue();
            //队列与交换机绑定（参数为：队列名称；交换机名称；routingKey忽略）
            channel.queueBind(queueName,"fanoutLogs","");

            logger.info("********Waiting for messages********");

            //这里重写了DefaultConsumer的handleDelivery方法，因为发送的时候对消息进行了getByte()，在这里要重新组装成String
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    super.handleDelivery(consumerTag, envelope, properties, body);
                    String message = new String(body,"UTF-8");
                    logger.info("received:" + message);
                }
            };

            //声明队列中被消费掉的消息（参数为：队列名称；消息是否自动确认;consumer主体）
            channel.basicConsume(queueName,true,consumer);
            //这里不能关闭连接，调用了消费方法后，消费者会一直连接着rabbitMQ等待消费
        } catch (IOException |TimeoutException e) {
            e.printStackTrace();
        }


    }

}