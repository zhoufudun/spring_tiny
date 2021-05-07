package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test9_arguments;

import com.rabbitmq.client.*;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

import java.util.HashMap;
import java.util.Map;

public class Producer {
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

        // 声明一个接收被删除的消息的交换机和队列
        String EXCHANGE_DEAD_NAME = "exchange.dead";
        String QUEUE_DEAD_NAME = "queue_dead";
        channel.exchangeDeclare(EXCHANGE_DEAD_NAME, BuiltinExchangeType.DIRECT);
        channel.queueDeclare(QUEUE_DEAD_NAME, false, false, false, null);
        channel.queueBind(QUEUE_DEAD_NAME, EXCHANGE_DEAD_NAME, "routingkey.dead");

        String EXCHANGE_NAME = "exchange.fanout";
        String QUEUE_NAME = "queue_name";
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        Map<String, Object> arguments = new HashMap<String, Object>();
        // 设置队列中的所有消息的生存周期(统一为整个队列的所有消息设置生命周期), 也可以在发布消息的时候单独为某个消息指定剩余生存时间,
        // 单位毫秒, 类似于redis中的ttl，生存时间到了，消息会被从队里中删除，注意是消息被删除，而不是队列被删除
        arguments.put("x-message-ttl", 15000);
        //当队列在指定的时间没有被访问(consume, basicGet, queueDeclare…)就会被删除
        arguments.put("x-expires", 30000);
        //限定队列的消息的最大值长度，超过指定长度将会把最早的几条删除掉， 类似于mongodb中的固定集合，例如保存最新的100条消息, Feature=Lim
        arguments.put("x-max-length", 4);
        //限定队列最大占用的空间大小， 一般受限于内存、磁盘的大小, Features=Lim B
        arguments.put("x-max-length-bytes", 1024);

        //当队列消息长度大于最大长度、或者过期的等，将从队列中删除的消息推送到指定的交换机中去而不是丢弃掉
        arguments.put("x-dead-letter-exchange", "exchange.dead");
        // 将删除的消息推送到指定交换机的指定路由键的队列中去
        arguments.put("x-dead-letter-routing-key", "routingkey.dead");
        channel.queueDeclare(QUEUE_NAME, true, false, false, arguments);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

        String message = "Hello RabbitMQ: ";
        for(int i = 1; i <= 5; i++) {
            channel.basicPublish(EXCHANGE_NAME, "", null, (message + i).getBytes("UTF-8"));
        }
        channel.close();
        connection.close();
    }
}
