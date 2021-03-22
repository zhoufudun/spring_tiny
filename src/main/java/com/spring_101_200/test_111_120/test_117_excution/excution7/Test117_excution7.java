package com.spring_101_200.test_111_120.test_117_excution.excution7;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Test117_excution7 {


    @Test
    //7.com.spring_1_100 包及所有子包下UserService前缀类型的的以test开头的只有一个参数类型为java.util.Date的方法，
    // 注意该匹配是根据方法签名的参数类型进行匹配的，而不是根据执行时传入的参数类型决定的如定义方法：public void test(Object obj);
    // 即使执行时传入java.util.Date，也不会匹配的；
    //@Pointcut("execution(* com.spring_1_100..UserServ*.test*(java.util.Date))")
    public void test7() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution7.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.testBirth(new Date());
        System.out.println("=============================");
        userService.testObject(new Date());

    }

}
