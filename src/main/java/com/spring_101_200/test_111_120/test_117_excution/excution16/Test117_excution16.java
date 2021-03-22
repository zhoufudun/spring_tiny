package com.spring_101_200.test_111_120.test_117_excution.excution16;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test117_excution16 {
//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring_117_excution/spring_117_excution13.xml");

    //16.任何带有一个参数的方法，且该参数类型持有@com.spring_1_100..MyAnnotation；如public void getUserInfo(User user);且User类上持有@MyAnnotation注解
    //@Pointcut("execution(* *(@com.spring_1_100..MyAnnotation *))")
    @Test
    public void test16() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution16.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUserInfo(new User());
        System.out.println("===========================");
        userService.getAge("李四", "83928392");
    }
}
