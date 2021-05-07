package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test3_confirm_select;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.impl.recovery.AutorecoveringChannel;
import com.rabbitmq.client.impl.recovery.RecoveryAwareChannelN;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;
import com.utils.ReflectionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.SortedSet;

public class Producer {
    // default exchange
    private static String exchange = "";
    // default exchange 的路由规则： routingKey（test） 将匹配同名的 queue(test)
    private static String routingKey = "test";

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
        // 4 开启消息确认机制
        channel.confirmSelect();

        // 6 添加消息确认监听（异步回调）
        // 第三种
        //异步confirm模式的编程实现最复杂，Channel对象提供的ConfirmListener()回调方法只包含deliveryTag（当前Chanel发出的消息序号），
        // 我们需要自己为每一个Channel维护一个unconfirm的消息序号集合，每publish一条数据，集合中元素加1，每回调一次handleAck方法，
        // unconfirm集合删掉相应的一条（multiple=false）或多条（multiple=true）记录。从程序运行效率上看，这个unconfirm集合最好
        // 采用有序集合SortedSet存储结构。实际上，SDK中的waitForConfirms()方法也是通过SortedSet维护消息序号的。
        //关键代码：
        Map<Long, Object> map = new HashMap<>();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("------------ack---------deliveryTag------" + deliveryTag + " -----multiple------  " + multiple);
                SortedSet<Long>  unconfirmedSet = getNotComfirmSeqNo(channel);
                if (multiple) {
                    unconfirmedSet.headSet(deliveryTag + 1).clear();
                } else {
                    unconfirmedSet.remove(deliveryTag);
                }
                System.out.println("剩余未确认的消息序列号：" + JSON.toJSONString(unconfirmedSet));
            }
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("------------no ack---------deliveryTag------" + deliveryTag + "----multiple---" + multiple);
                System.out.println("服务器内部失败的消息 serNo：" +deliveryTag);
            }
        });

        Random random = new Random();
        // 5 发送消息
        for (int i = 0; i < 10; i++) {
            long nextSeqNo = channel.getNextPublishSeqNo();
            String msg = "消息确认模式：RabbitMQ send confirm message " + i;
            channel.basicPublish(exchange, routingKey, null, msg.getBytes());
            System.out.println("生产者发布消息后，剩余未确认的消息序列号:" + JSON.toJSONString( getNotComfirmSeqNo(channel)));
            map.put(nextSeqNo, msg);
        }
        if (!channel.waitForConfirms()) {
            SortedSet<Long> object = getNotComfirmSeqNo(channel);
            System.out.println(JSON.toJSONString(object));
            System.out.println("发送消息丢失的消息如下：");
            System.out.println(JSON.toJSONString(getNotComfirmSeqNo(channel)));
            // 可以做我们的业务了
        }else{
            System.out.println("本次发送的所有消息都被服务器接收");
            System.out.println(JSON.toJSONString(getNotComfirmSeqNo(channel)));
        }
    }

    public static SortedSet<Long> getNotComfirmSeqNo(Channel channel) {
        if(channel instanceof AutorecoveringChannel){
            RecoveryAwareChannelN channelN = (RecoveryAwareChannelN) ReflectionUtils.getObjectFieldValue(channel, "delegate");
            return (SortedSet<Long>) ReflectionUtils.getObjectFieldValue(channelN, "unconfirmedSet");
        }
        return null;
    }

}
