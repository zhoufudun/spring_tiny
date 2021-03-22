package com.spring_1_100.test_91_100.test92_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test92 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_91_100/spring92_annotation.xml");
        Waiter waiter = ctx.getBean(Waiter.class);
        waiter.greetTo("tom");
        waiter.serviceTo("quyixiao");
    }

}
