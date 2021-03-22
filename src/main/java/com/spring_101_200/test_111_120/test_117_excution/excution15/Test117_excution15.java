package com.spring_101_200.test_111_120.test_117_excution.excution15;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test117_excution15 {
//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring_117_excution/spring_117_excution13.xml");

    @Test
    //15.任何签名带有两个参数的方法，且这个两个参数都被@ MyAnnotation 标记了，如public void test(@MyAnnotation String str1,@MyAnnotation String str1);
    //@Pointcut("execution(* *(@com.spring_1_100..MyAnnotation (*),@com.spring_1_100..MyAnnotation (*)))")
    public void test15() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution15.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUser("张三", "123456");
        System.out.println("===========================");
        userService.getAge("李四", "83928392");
    }

}
