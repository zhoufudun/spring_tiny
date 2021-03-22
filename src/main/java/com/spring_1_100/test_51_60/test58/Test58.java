package com.spring_1_100.test_51_60.test58;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test58 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_51_60/spring58.xml");

        HelloMessage us = ac.getBean(HelloMessage.class);
        System.out.println(us.getMsg());
    }
}
