package com.spring_101_200.test_111_120.test_117_excution.excution22;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test117_excution22 {
//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring_117_excution/spring_117_excution13.xml");

    @Test
    public void test14() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution22.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getAge("zhangsan","123456");
    }
}
