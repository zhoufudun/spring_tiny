package com.spring_1_100.test_51_60.test60;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test60 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_51_60/spring60.xml");
        User user = ac.getBean(User.class);
        Person user1 = ac.getBean(Person.class);

        System.out.println(user);

    }
}
