package com.spring_101_200.test_111_120.test_117_excution.excution11;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test117_excution11 {

    //11.任何持有@java.lang.Deprecated和@cn.javass..Secure注解的方法
    //@Pointcut("execution(@java.lang.Deprecated @com.spring_1_100..MyAnnotation * *(..))")
    @Test
    public void test() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution11.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.testDeprecated();
        System.out.println("===========================");
        userService.testDeprecatedMyAnnotation();
    }
}
