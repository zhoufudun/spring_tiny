package com.spring_1_100.test_31_40.test37;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test37 {


    @Test
    public void test1() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring37_2.xml");
        System.out.println(((TestA) bf.getBean("testA")).getTestB().getTestC().getTestA());
    }


    @Test
    public void test2() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring37.xml");
        System.out.println(((TestA) bf.getBean("testA")).getTestB().getTestC().getTestA());
    }


    @Test
    public void test3() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring37_3.xml");
        System.out.println(((TestA) bf.getBean("testA")).getTestB().getTestC().getTestA());
    }

}