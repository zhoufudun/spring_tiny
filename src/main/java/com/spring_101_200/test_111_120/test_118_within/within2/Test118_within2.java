package com.spring_101_200.test_111_120.test_118_within.within2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test118_within2 {
    //ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring118_within/spring_118_within1.xml");


    // 2.com..test64_2 包或所有子包下 类型及子类型的任何方法
    //@Pointcut("within(com..test64_2..UserService+)")
    @Test
    public void within2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring118_within/spring_118_within2.xml");
        Car car = ac.getBean(Car.class);
        car.driver();
        System.out.println("=============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUser();
    }
}
