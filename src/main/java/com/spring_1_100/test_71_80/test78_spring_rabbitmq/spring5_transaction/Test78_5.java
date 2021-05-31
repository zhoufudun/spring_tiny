package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring5_transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test78_5 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring78_rabbitmq/spring78_mq_sender5.xml");
        TransactionSevice transactionSevice = context.getBean(TransactionSevice.class);
        transactionSevice.testTransaction();
    }
}
