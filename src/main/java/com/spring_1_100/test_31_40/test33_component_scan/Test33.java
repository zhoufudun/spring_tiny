package com.spring_1_100.test_31_40.test33_component_scan;


import com.spring_1_100.test_1_10.test.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test33 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring33_component_scan.xml");
        LogonService logonService= (LogonService)ac.getBean("logonService");

    }
}


