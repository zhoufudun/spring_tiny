package com.spring_101_200.test_111_120.test_117_excution.excution10;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test117_excution10 {

    //10.任何持有@java.lang.Deprecated注解的方法
    //@Pointcut("execution(@java.lang.Deprecated * *(..))")
    @Test
    public void test10() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution10.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.testIllegalArgumentException();
        System.out.println("===========================");
        userService.testDeprecated();
    }

}
