package com.spring_1_100.test_61_70.test65_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test65_2 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring65_2.xml");

        AserviceImpl service = (AserviceImpl) ac.getBean("aservice");
        service.b("quyixiao", "hukaiming");
        System.out.println("======================");
        service.a();
    }
}
