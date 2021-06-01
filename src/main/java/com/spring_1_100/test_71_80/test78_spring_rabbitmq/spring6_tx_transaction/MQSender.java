package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring6_tx_transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MQSender {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring78_rabbitmq/spring6/spring78_mq_sender6.xml");
        TransactionSevice transactionSevice = context.getBean(TransactionSevice.class);
        transactionSevice.testTransaction();
    }
}
