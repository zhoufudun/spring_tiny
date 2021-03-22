package com.spring_1_100.test_61_70.test65;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.ws.Service;

public class Test65 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring65.xml");

        Aservice service =(Aservice) ac.getBean("aservice");
        service.b("quyixiao","hukaiming");
    }
}
