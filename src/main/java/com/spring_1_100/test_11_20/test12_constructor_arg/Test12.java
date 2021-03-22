package com.spring_1_100.test_11_20.test12_constructor_arg;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test12 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_11_20/spring12_constructor_arg.xml");
        Car foo = (Car) ac.getBean("car");
        Boss boss = (Boss) ac.getBean("boss");
        System.out.println(JSON.toJSONString(foo));
        System.out.println(JSON.toJSONString(boss));

    }
}
