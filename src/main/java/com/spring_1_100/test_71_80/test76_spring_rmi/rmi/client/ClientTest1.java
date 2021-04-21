package com.spring_1_100.test_71_80.test76_spring_rmi.rmi.client;

import com.spring_1_100.test_71_80.test76_spring_rmi.HelloRMIService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientTest1 {

    public static void main(String[] args) {
        ApplicationContext ct = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring76_rmi/spring76_client1.xml");

        HelloRMIService helloRMIService = ct.getBean("myClient",HelloRMIService.class);
        int c = helloRMIService.getAdd(1,2);
        System.out.println(c);

    }
}
