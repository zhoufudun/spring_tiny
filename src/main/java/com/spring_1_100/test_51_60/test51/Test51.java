package com.spring_1_100.test_51_60.test51;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Test51 {


    @Autowired
    private UserService userServiceImpl1;
    @Autowired
    private UserService userServiceImpl2;


    @Test
    public void test1() {

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_51_60/spring51.xml");

        Test51 test51 = ac.getBean(Test51.class);
        System.out.println(test51.userServiceImpl1.getUserName());

    }
}
