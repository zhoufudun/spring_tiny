package com.spring_1_100.test_31_40.test39;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test39 {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring39.xml");


        UserManager userManager = (UserManager) bf.getBean("userManager");
        System.out.println(userManager);


    }
}



