package com.spring_1_100.test_71_80.test77_spring_httpinvoker.client;

import com.spring_1_100.test_71_80.test77_spring_httpinvoker.service.HttpInvokerTestI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test77_Client {

    public static void main(String[] args) {
        ApplicationContext ct = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring77_httpinvoker/spring77_client.xml");

        HttpInvokerTestI httpInvokerTestI = (HttpInvokerTestI) ct.getBean("remoteService");
        System.out.println(httpInvokerTestI.getTestPo("dddd"));

    }
}
