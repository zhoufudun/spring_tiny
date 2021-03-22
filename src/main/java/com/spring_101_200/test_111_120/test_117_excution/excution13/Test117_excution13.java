package com.spring_101_200.test_111_120.test_117_excution.excution13;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test117_excution13 {


    @Test
    //13. 任何返回值类型持有@cn.javass..Secure的方法
    //@Pointcut("execution((@com.spring_1_100..MyAnnotation *) *(..))")
    public void test13() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution13.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUser();
        System.out.println("===========================");
        userService.getAge();
    }
}
