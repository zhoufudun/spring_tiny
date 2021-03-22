package com.spring_1_100.test_51_60.test57;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test57 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_51_60/spring57.xml");

        User user = ac.getBean(User.class);
        System.out.println(user.getAge());

    }
}
