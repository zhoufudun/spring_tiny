package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test8_reject;

import com.rabbitmq.client.*;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 拒绝消息的消费者
 */
public class ConsumerReject {

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
        //在信道中设置交换器
        channel.exchangeDeclare(Producer.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        //申明队列
        String queueName = "rejectqueue";
        channel.queueDeclare(queueName, false, false, false, null);

        //绑定：将队列与交换器通过路由键绑定
        String routeKey = "error";
        channel.queueBind(queueName, Producer.EXCHANGE_NAME, routeKey);
        System.out.println("waiting for message ......");

        //申明一个消费者
        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    String message = new String(body, "UTF-8");
                    System.out.println("Receive[" + envelope.getRoutingKey() + "]" + message);
                    throw new RuntimeException("异常处理" + message);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    //Reject方式拒绝（第二个参数决定是否重新投递，设置为true表示重新投递，设置false则消息丢失）
                    channel.basicReject(envelope.getDeliveryTag(), true);
                    //Nack方式拒绝（第二个参数决定是否批量,第三个参数决定是否重新投递）
//                    channel.basicNack(envelope.getDeliveryTag(), true, true);
                }
            }
        };
        channel.basicConsume(queueName, false, consumer);
    }
}