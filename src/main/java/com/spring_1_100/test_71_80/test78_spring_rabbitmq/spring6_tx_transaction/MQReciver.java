package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring6_tx_transaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xuexiaolei
 * @version 2017年08月22日
 */
public class MQReciver {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring78_rabbitmq/spring6/spring78_mq_recive6.xml");
    }

}