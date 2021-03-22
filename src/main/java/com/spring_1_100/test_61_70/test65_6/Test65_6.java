package com.spring_1_100.test_61_70.test65_6;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test65_6 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring65_6.xml");
        Aservice service = (Aservice)ac.getBean("aservice");
        service.b("98ds9889ds",new User());


        Advised advised = (Advised)ac.getBean("aservice");
        advised.isFrozen();

    }
}
