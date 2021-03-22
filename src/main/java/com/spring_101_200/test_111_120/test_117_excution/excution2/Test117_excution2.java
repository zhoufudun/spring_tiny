package com.spring_101_200.test_111_120.test_117_excution.excution2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test117_excution2 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution2.xml");
        System.out.println("==================================");
        MyService myService = ac.getBean(MyService.class);
        System.out.println("======================");
        myService.service();
    }



    @Test
    public void test(){
        System.out.println("Java二进制1: "+Integer.toBinaryString(17));
        System.out.println("Java二进制4: "+Integer.toBinaryString(1));
        System.out.println(4 & 1 );
    }
}
