package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring8_cache_mode;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.utils.InvokeUtils;
import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.*;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuexiaolei
 * @version 2017年08月22日
 */

public class MQSender {

    public static final String queue_key = "test_queue_key";


    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring78_rabbitmq/spring8/spring78_mq_sender8.xml");
        Map<String, Object> msg = new HashMap();
        msg.put("data", "hello,rabbmitmq!");
        msg.put("time", System.currentTimeMillis());
        System.out.println("++++++++++++++++++++" + JSON.toJSONString(msg));
        RabbitTemplate rabbitTemplate = (RabbitTemplate) context.getBean("rabbitTemplate");
        rabbitTemplate.convertAndSend(queue_key, msg);
        rabbitTemplate.convertAndSend(queue_key, msg);
    }

    @Test
    public void test2() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring78_rabbitmq/spring8/spring78_mq_sender8.xml");
        RabbitTemplate rabbitTemplate = (RabbitTemplate) context.getBean("rabbitTemplate");
        Map<String, Object> msg = new HashMap();
        msg.put("data", "hello,rabbmitmq!");
        msg.put("time", System.currentTimeMillis());
        org.springframework.expression.Expression expression = InvokeUtils.getFieldValue(rabbitTemplate, "sendConnectionFactorySelectorExpression");
        String exchange = InvokeUtils.getFieldValue(rabbitTemplate, "exchange");
        Message message = (Message) InvokeUtils.invokeMethod(rabbitTemplate, "convertMessageIfNecessary", msg);
        System.out.println(JSON.toJSONString(message));
        ConnectionFactory connectionFactory = (ConnectionFactory) InvokeUtils.invokeMethod(rabbitTemplate, "obtainTargetConnectionFactoryIfNecessary", expression, message);
        System.out.println("connectionFactory = " + connectionFactory);

        CachingConnectionFactory cachingConnectionFactory = (CachingConnectionFactory)context.getBean("connectionFactory");
        RabbitResourceHolder resourceHolder1 = ConnectionFactoryUtils.getTransactionalResourceHolder(
                (connectionFactory != null ? connectionFactory : cachingConnectionFactory), false);

        Channel channel1 = resourceHolder1.getChannel();
        ChannelProxy channelProxy1 = (ChannelProxy) channel1;
        Channel targetChannel1 = channelProxy1.getTargetChannel();
        InvokeUtils.invokeMethod(rabbitTemplate, "doSend", channel1, exchange, queue_key, message, true, null);


        RabbitResourceHolder resourceHolder2 = ConnectionFactoryUtils.getTransactionalResourceHolder(
                (connectionFactory != null ? connectionFactory : cachingConnectionFactory), false);
        Channel channel2 = resourceHolder2.getChannel();


        ChannelProxy channelProxy2 = (ChannelProxy) channel2;
        Channel targetChannel2 = channelProxy2.getTargetChannel();
        System.out.println(targetChannel1 == targetChannel2);


        InvokeUtils.invokeMethod(rabbitTemplate, "doSend", channel1, exchange, queue_key, message, true, null);
        channelProxy1.close();
        resourceHolder1.getConnection().close();

        channelProxy2.close();
        resourceHolder2.getConnection().close();
    }

    @Test
    public void test3() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring78_rabbitmq/spring8/spring78_mq_sender8.xml");
        RabbitTemplate rabbitTemplate = (RabbitTemplate) context.getBean("rabbitTemplate");
        Map<String, Object> msg = new HashMap();
        msg.put("data", "hello,rabbmitmq!");
        msg.put("time", System.currentTimeMillis());
        org.springframework.expression.Expression expression = InvokeUtils.getFieldValue(rabbitTemplate, "sendConnectionFactorySelectorExpression");
        String exchange = InvokeUtils.getFieldValue(rabbitTemplate, "exchange");
        Message message = (Message) InvokeUtils.invokeMethod(rabbitTemplate, "convertMessageIfNecessary", msg);
        System.out.println(JSON.toJSONString(message));
        ConnectionFactory connectionFactory = (ConnectionFactory) InvokeUtils.invokeMethod(rabbitTemplate, "obtainTargetConnectionFactoryIfNecessary", expression, message);
        System.out.println("connectionFactory = " + connectionFactory);

        CachingConnectionFactory cachingConnectionFactory = (CachingConnectionFactory)context.getBean("connectionFactory");
        RabbitResourceHolder resourceHolder1 = ConnectionFactoryUtils.getTransactionalResourceHolder(
                (connectionFactory != null ? connectionFactory : cachingConnectionFactory), false);

        Channel channel1 = resourceHolder1.getChannel();
        ChannelProxy channelProxy1 = (ChannelProxy) channel1;
        Channel targetChannel1 = channelProxy1.getTargetChannel();
        InvokeUtils.invokeMethod(rabbitTemplate, "doSend", channel1, exchange, queue_key, message, true, null);
        channel1.close();
        Connection connection1 = resourceHolder1.getConnection();
        connection1.close();

        RabbitResourceHolder resourceHolder2 = ConnectionFactoryUtils.getTransactionalResourceHolder(
                (connectionFactory != null ? connectionFactory : cachingConnectionFactory), false);
        Channel channel2 = resourceHolder2.getChannel();
        ChannelProxy channelProxy2 = (ChannelProxy) channel2;
        Channel targetChannel2 = channelProxy2.getTargetChannel();
        System.out.println(targetChannel1 == targetChannel2);
        InvokeUtils.invokeMethod(rabbitTemplate, "doSend", channel1, exchange, queue_key, message, true, null);

        channel2.close();
        resourceHolder2.getConnection().close();

    }
}