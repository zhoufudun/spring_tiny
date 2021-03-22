package com.spring_101_200.test_111_120.test_117_excution.excution4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test117_excution4 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution4.xml");
        MyService myService = ac.getBean(MyService.class);
        myService.service();
    }
}
