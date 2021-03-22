package com.spring_1_100.test_41_50.test45;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test45 {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_41_50/spring45.xml");
        Animal animal = bf.getBean(Animal.class);
        System.out.println(animal.getPerson());

    }
}
