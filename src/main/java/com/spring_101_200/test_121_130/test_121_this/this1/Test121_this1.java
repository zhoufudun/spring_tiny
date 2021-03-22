package com.spring_101_200.test_121_130.test_121_this.this1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test121_this1 {
//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring_117_excution/spring_117_excution13.xml");


    //this
    //1.当前AOP对象实现了 UserService 接口的任何方法
    @Test
    public void this1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_121_130/spring121_this/spring_121_this1.xml");
        Car car = ac.getBean(Car.class);
        car.driver();
        System.out.println("===========================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUser();
    }
}
