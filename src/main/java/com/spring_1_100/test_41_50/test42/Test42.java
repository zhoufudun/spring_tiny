package com.spring_1_100.test_41_50.test42;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test42 {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_41_50/spring42.xml");
        TestChangeMethod testChangeMethod =(TestChangeMethod) bf.getBean("testChangeMethod");
        testChangeMethod.changeMe();
    }
}



