package com.spring_1_100.test_41_50.test48;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test48 {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_41_50/spring48.xml");


        MyPerson myPerson = bf.getBean(MyPerson.class);
        System.out.println(myPerson.getPerson());

    }
}
