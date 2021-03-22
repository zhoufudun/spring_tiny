package com.spring_1_100.test_11_20.test18_property_null;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test18 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_11_20/spring18_property_null.xml");
        Car car = ac.getBean(Car.class);
        System.out.println(car.getBrand()); // <value></value> 是一个空串
        System.out.println(car.getBrand().equals(""));
        System.out.println(car.getColor()); // <null></null> 这个才是 null 值
    }
}
