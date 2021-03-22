package com.spring_101_200.test_111_120.test_117_excution.excution8;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Test117_excution8 {



    @Test
    //8.com.spring_1_100 包及所有子包下UserSe前缀类型的的任何方法，且抛出IllegalArgumentException和ArrayIndexOutOfBoundsException异常，需要同时抛出
    //@Pointcut("execution(* com.spring_1_100..UserSe*.test*(..) throws IllegalArgumentException, ArrayIndexOutOfBoundsException)")
    public void test8() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution8.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.testException(new Date());
        System.out.println("=============================");
        userService.testIllegalArgumentException();

    }
}
