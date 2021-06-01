package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring5_transaction;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.utils.InvokeUtils;
import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuexiaolei
 * @version 2017年08月22日
 */

public class MQSender {
    public static final String queue_key = "test_queue_key";

    @Test
    public void test() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring78_rabbitmq/spring78_mq_sender5.xml");
        RabbitTemplate rabbitTemplate = (RabbitTemplate) context.getBean("rabbitTemplate");
        Map<String, Object> msg = new HashMap();
        msg.put("data", "hello,rabbmitmq!");
        msg.put("time", System.currentTimeMillis());
        org.springframework.expression.Expression expression = InvokeUtils.getFieldValue(rabbitTemplate, "sendConnectionFactorySelectorExpression");
        String exchange = InvokeUtils.getFieldValue(rabbitTemplate, "exchange");
        Message message = (Message) InvokeUtils.invokeMethod(rabbitTemplate, "convertMessageIfNecessary", msg);
        System.out.println(JSON.toJSONString(message));
        ConnectionFactory connectionFactory = (ConnectionFactory) InvokeUtils.invokeMethod(rabbitTemplate, "obtainTargetConnectionFactoryIfNecessary", expression, message);
        TransactionSynchronizationManager.setActualTransactionActive(true);
        ChannelCallback channelCallback = new ChannelCallback<Object>() {
            @Override
            public Object doInRabbit(Channel channel) throws Exception {
                InvokeUtils.invokeMethod(rabbitTemplate, "doSend", channel, exchange, queue_key, message, true, null);
                int i = 0;
                int j = 1;
                int c = j / i;
                return null;
            }
        };
        System.out.println("connectionFactory = " + connectionFactory);
        System.out.println("channelCallback=" + channelCallback);
        InvokeUtils.invokeMethod(rabbitTemplate, "execute", channelCallback, connectionFactory);
    }


}