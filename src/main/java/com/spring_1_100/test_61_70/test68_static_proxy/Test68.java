package com.spring_1_100.test_61_70.test68_static_proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test68 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring68.xml");

        Aservice service =(Aservice) ac.getBean("aservice");
        service.b("quyixiao","hukaiming");




    }
}
