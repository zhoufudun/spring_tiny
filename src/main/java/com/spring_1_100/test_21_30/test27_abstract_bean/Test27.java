package com.spring_1_100.test_21_30.test27_abstract_bean;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test27 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_21_30/spring27_abstract_bean.xml");


        Car car =(Car) ac.getBean("car4");
        System.out.println(JSON.toJSONString(car));
    }
}
