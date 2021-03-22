package com.spring_101_200.test_111_120.test_117_excution.excution14;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test117_excution14 {
//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring_117_excution/spring_117_excution13.xml");

    @Test
    //14.任何定义方法的类型持有@com.spring_1_100..MyAnnotation的方法 【这个目前有问题，没有测试出来】
    //@Pointcut("execution(* (@com.spring_1_100..MyAnnotation *).*(..))")
    public void test14() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution14.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
       // userService.getAge();
        System.out.println("===========================");
        userService.getParentName();
    }
}
