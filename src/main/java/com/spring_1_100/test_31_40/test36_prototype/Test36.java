package com.spring_1_100.test_31_40.test36_prototype;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test36 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring36_prototype.xml");


        Car car  = (Car)ac.getBean("car");
        Car car1  = (Car)ac.getBean("car");
        System.out.println(car == car1);
    }
}


