package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring8_cache_mode;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuexiaolei
 * @version 2017年08月22日
 */
public class MQReciver {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring78_rabbitmq/spring8/spring78_mq_recive8.xml");
    }

}