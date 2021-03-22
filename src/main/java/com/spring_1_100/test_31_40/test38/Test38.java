package com.spring_1_100.test_31_40.test38;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test38 {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring38.xml");


        UserManager userManager = (UserManager) bf.getBean("userManager");
        System.out.println(userManager);


    }
}



