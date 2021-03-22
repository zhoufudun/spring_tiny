package com.spring_101_200.test_121_130.test_123_annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test123_annotation {
//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring_117_excution/spring_117_excution13.xml");


    @Test
    public void annotation1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_121_130/spring123_annotation/spring_123_annotation1.xml");

        MyService myService = ac.getBean(MyService.class);
        myService.select();
    }


}
