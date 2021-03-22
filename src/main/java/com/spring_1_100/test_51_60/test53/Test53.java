package com.spring_1_100.test_51_60.test53;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test53 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_51_60/spring53.xml");

        TestBeanFactory beanFactory = ac.getBean(TestBeanFactory.class);
        beanFactory.testAware();


    }
}
