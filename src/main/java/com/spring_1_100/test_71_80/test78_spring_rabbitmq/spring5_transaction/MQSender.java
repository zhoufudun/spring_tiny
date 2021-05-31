package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring5_transaction;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

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
    public void test() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring78_rabbitmq/spring78_mq_sender5.xml");
        RabbitTemplate rabbitTemplate =(RabbitTemplate) context.getBean("rabbitTemplate");

        Map<String, Object> msg = new HashMap();
        msg.put("data", "hello,rabbmitmq!");
        msg.put("time", System.currentTimeMillis());

        org.springframework.expression.Expression expression = getFieldValue(rabbitTemplate,"sendConnectionFactorySelectorExpression");
        String exchange = getFieldValue(rabbitTemplate,"exchange");
        Message message = (Message)  invokeMethod(rabbitTemplate,"convertMessageIfNecessary",msg);
        System.out.println(JSON.toJSONString(message));
        ConnectionFactory connectionFactory = (ConnectionFactory)  invokeMethod(rabbitTemplate,"obtainTargetConnectionFactoryIfNecessary",expression,message);
        RabbitTransactionManager rabbitTransactionManager = context.getBean(RabbitTransactionManager.class);
        //ConnectionFactory connectionFactory  =  rabbitTransactionManager.getConnectionFactory();
        ChannelCallback channelCallback =   new ChannelCallback<Object>() {
            @Override
            public Object doInRabbit(Channel channel) throws Exception {
                invokeMethod(rabbitTemplate,"doSend",channel, exchange, queue_key, message, true, null);
                int i = 0 ;
                int j = 1;
                int c = j / i ;
                return null;
            }
        };
        System.out.println("connectionFactory = " + connectionFactory);
        System.out.println("channelCallback="+channelCallback);
        invokeMethod(rabbitTemplate,"execute",channelCallback,connectionFactory);
    }




    public static Object invokeMethod(Object object, String methodName, Object ... parameters) {
        //根据 对象、方法名和对应的方法参数 通过反射 调用上面的方法获取 Method 对象
        Method method = getDeclaredMethod(object, methodName,parameters !=null  ? parameters.length : 0 );
        //抑制Java对方法进行检查,主要是针对私有方法而言
        method.setAccessible(true);
        try {
            if (null != method) {

                //调用object 的 method 所代表的方法，其方法的参数是 parameters
                return method.invoke(object, parameters);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



    public static Method getDeclaredMethod(Object object, String methodName,int length) {
        Method method = null;

        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method m : methods) {
                    if (m.getName().equals(methodName) && (m.getParameterTypes() !=null ? m.getParameterTypes().length :0 ) == length) {
                        System.out.println("methodName :" + methodName + ",paramter.size = " + length);
                        return m;
                    }
                }
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }

        return null;
    }







    public static Method getMethod(Class clazz, String methodName) {
        Method methods[] = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            if (methodName.equals(method.getName())) {
                return method;
            }
        }
        return null;
    }

    public static <T> T getFieldValue(Object target, String name) {
        Field field = getField(target.getClass(), name);
        if (field != null) {
            try {
                field.setAccessible(true);
                return (T) field.get(target);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Field getField(Class clazz, String name) {
        Field fields[] = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (name.equals(field.getName())) {
                return field;
            }
        }
        return null;
    }

}