package com.spring_1_100.test_21_30.test25_lookup_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test25 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_21_30/spring25_lookup_method.xml");


        MagicBoss boss = (MagicBoss) ac.getBean("boss");

        Car car1 = boss.getCar();
        Car car2 = boss.getCar();

        System.out.println(car1 == car2);
    }
}
