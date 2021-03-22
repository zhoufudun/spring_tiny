package com.spring_101_200.test_111_120.test_120_args.args2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test120_args2 {
    //ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring118_within/spring_118_within1.xml");



    //2.任何一个只接受一个参数的方法，且方法运行时传入的参数持有注解 cn.javass.spring.chapter6.Secure；动态切入点，类似于arg指示符；
    //@Pointcut("@args(com.spring_1_100.test_61_70.test64_2.MyAnnotation,..)")  【aop重要】
    @Test
    public void args2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring120_args/spring_120_args2.xml");
        System.out.println("===========================");
        UserService userService = ac.getBean(UserService.class);
        userService.testArgs1(new Model());
        System.out.println("===========================");
        userService.getUserInfo(new User());
    }
}
