package com.spring_1_100.test_21_30.test29_reference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test29 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_21_30/spring29_reference.xml");

        Boss boss = (Boss) ac.getBean("boss1");
        System.out.println(boss.getCarId());


        Boss boss2 = (Boss) ac.getBean("boss2");

        System.out.println(boss2.getCarId());

    }
}
