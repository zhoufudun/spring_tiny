package com.spring_101_200.test_111_120.test_120_args.args1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test120_args1 {
    //ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring118_within/spring_118_within1.xml");






    // args
    // 1.任何一个以接受“传入参数类型为 java.io.Serializable” 开头，且其后可跟任意个任意类型的参数的方法执行，args指定的参数类型是在运行时动态匹配的
    //@Pointcut("args(java.io.Serializable,..)")
    @Test
    public void args1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring120_args/spring_120_args1.xml");

        System.out.println("===========================");
        UserService userService = ac.getBean(UserService.class);

        userService.testArgs2(new Model(),"83982");
        System.out.println("===========================");
        userService.getUser();
    }
}
