package com.spring_1_100.test_11_20.test15_factory_method;


import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test15 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_11_20/spring15_factory_method.xml");
        Car car =(Car) ac.getBean("car");
        System.out.println(JSON.toJSONString(car));

        Car car2 =(Car) ac.getBean("car2");
        System.out.println(JSON.toJSONString(car2));

    }
}
