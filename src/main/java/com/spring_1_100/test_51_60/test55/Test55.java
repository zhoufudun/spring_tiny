package com.spring_1_100.test_51_60.test55;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test55 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_51_60/spring55.xml");
        ((ClassPathXmlApplicationContext)ac).close();
    }
}
