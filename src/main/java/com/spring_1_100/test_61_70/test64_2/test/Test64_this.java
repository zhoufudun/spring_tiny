package com.spring_1_100.test_61_70.test64_2.test;

import com.spring_1_100.test_61_70.test64_2.Car;
import com.spring_1_100.test_61_70.test64_2.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test64_this {



    //this
    //1.当前AOP对象实现了 UserService 接口的任何方法
    @Test
    public void this1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        Car car = ac.getBean(Car.class);
        car.driver();

        System.out.println("===========================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUser();
    }
}
