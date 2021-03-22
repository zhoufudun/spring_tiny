package com.spring_101_200.test_111_120.test_119_target.target2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test119_target2 {
//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring_117_excution/spring_117_excution13.xml");

    //target
    //1.当前目标对象（非AOP对象）实现了 IPointcutService 接口的任何方法
    //@Pointcut("target(com.spring_1_100.test_61_70.test64_2.UserService)")
    @Test
    public void target1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring119_target/spring_119_target2.xml");
        Car car = ac.getBean(Car.class);
        car.driver();

        System.out.println("===========================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUser();
    }



}
