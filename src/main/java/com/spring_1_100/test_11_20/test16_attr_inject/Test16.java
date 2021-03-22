package com.spring_1_100.test_11_20.test16_attr_inject;


import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test16 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_11_20/spring16_attr_inject.xml");
        Car car = ac.getBean(Car.class);
        System.out.println(JSON.toJSONString(car));


    }
}
