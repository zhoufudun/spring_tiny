package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring5_transaction;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.utils.InvokeUtils;
import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.RabbitUtils;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.MessagePropertiesConverter;
import org.springframework.amqp.rabbit.support.PublisherCallbackChannel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Collection;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring78_rabbitmq/spring5/spring78_mq_sender5.xml");
        RabbitTemplate rabbitTemplate = (RabbitTemplate) context.getBean("rabbitTemplate");
        Map<String, Object> msg = new HashMap();
        msg.put("data", "hello,rabbmitmq!");
        msg.put("time", System.currentTimeMillis());
        org.springframework.expression.Expression expression = InvokeUtils.getFieldValue(rabbitTemplate, "sendConnectionFactorySelectorExpression");

        Message message = (Message) InvokeUtils.invokeMethod(rabbitTemplate, "convertMessageIfNecessary", msg);
        System.out.println(JSON.toJSONString(message));
        ConnectionFactory connectionFactory = (ConnectionFactory) InvokeUtils.invokeMethod(rabbitTemplate, "obtainTargetConnectionFactoryIfNecessary", expression, message);
        ChannelCallback channelCallback = new ChannelCallback<Object>() {
            @Override
            public Object doInRabbit(Channel channel) throws Exception {
                String exchange = InvokeUtils.getFieldValue(rabbitTemplate, "exchange");
                String routingKey = queue_key;
                InvokeUtils.invokeMethod(rabbitTemplate, "setupConfirm", channel, null);
                Message messageToUse = message;
                MessageProperties messageProperties = messageToUse.getMessageProperties();
                if (false) {
                    messageProperties.getHeaders().put(PublisherCallbackChannel.RETURN_CORRELATION_KEY, InvokeUtils.getFieldValue(rabbitTemplate, "uuid"));
                }
                Collection<MessagePostProcessor> beforePublishPostProcessors = InvokeUtils.getFieldValue(rabbitTemplate, "beforePublishPostProcessors");
                if (beforePublishPostProcessors != null) {
                    for (MessagePostProcessor processor : beforePublishPostProcessors) {
                        messageToUse = processor.postProcessMessage(messageToUse);
                    }
                }
                Expression userIdExpression = InvokeUtils.getFieldValue(rabbitTemplate, "userIdExpression");
                if (userIdExpression != null && messageProperties.getUserId() == null) {
                    StandardEvaluationContext evaluationContext = InvokeUtils.getFieldValue(rabbitTemplate, "evaluationContext");
                    String userId = userIdExpression.getValue(evaluationContext, messageToUse, String.class);
                    if (userId != null) {
                        messageProperties.setUserId(userId);
                    }
                }
                MessagePropertiesConverter messagePropertiesConverter = InvokeUtils.getFieldValue(rabbitTemplate, "messagePropertiesConverter");
                AMQP.BasicProperties convertedMessageProperties = messagePropertiesConverter.
                        fromMessageProperties(messageProperties, InvokeUtils.getFieldValue(rabbitTemplate, "encoding"));
                channel.basicPublish(exchange, routingKey, false, convertedMessageProperties, messageToUse.getBody());
                int i = 0;
                int j = 1;
                int c = j / i;
                // Check if commit needed
                boolean flag = (boolean) InvokeUtils.invokeMethod(rabbitTemplate, "isChannelLocallyTransacted", channel);
                if (flag) {
                    // Transacted channel created by this template -> commit.
                    RabbitUtils.commitIfNecessary(channel);
                }
                return null;
            }
        };
        System.out.println("connectionFactory = " + connectionFactory);
        System.out.println("channelCallback=" + channelCallback);
        InvokeUtils.invokeMethod(rabbitTemplate, "execute", channelCallback, connectionFactory);
    }


}