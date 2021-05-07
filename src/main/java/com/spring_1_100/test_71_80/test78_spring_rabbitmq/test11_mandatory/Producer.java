package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test11_mandatory;

import com.rabbitmq.client.*;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

import java.io.IOException;

public class Producer {

    public static void main(String[] args) {
        try {
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
            channel.basicQos(1);
            channel.exchangeDeclare("mandatory-test", BuiltinExchangeType.DIRECT);
            //当mandatory标志位设置为true时，如果exchange根据自身类型和消息routeKey无法找到一个符合条件的queue，那么会调用basic.return方法将消息返回给生产者
            // （Basic.Return + Content-Header + Content-Body）；当mandatory设置为false时，出现上述情形broker会直接将消息扔掉。

            // 当immediate标志位设置为true时，如果exchange在将消息路由到queue(s)时发现对于的queue上么有消费者，那么这条消息不会放入队列中。
            // 当与消息routeKey关联的所有queue（一个或者多个）都没有消费者时，该消息会通过basic.return方法返还给生产者。

            // 概括来说，mandatory标志告诉服务器至少将该消息route到一个队列中，否则将消息返还给生产者；immediate标志告诉服务器如果该消息关联的queue上有消费者，
            // 则马上将消息投递给它，如果所有queue都没有消费者，直接把消息返还给生产者，不用将消息入队列等待消费者了。
            channel.basicPublish("mandatory-test", "", true, false, MessageProperties.PERSISTENT_TEXT_PLAIN, "===mandatory===".getBytes());
            channel.addReturnListener(new ReturnListener() {
                public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties basicProperties, byte[] body) throws IOException {
                    String message = new String(body);
                    System.out.println("Basic.return返回的结果是："+message);
                }
            });

           // channel.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
