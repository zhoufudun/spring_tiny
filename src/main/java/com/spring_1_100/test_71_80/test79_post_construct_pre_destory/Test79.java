package com.spring_1_100.test_71_80.test79_post_construct_pre_destory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test79 {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring79_post_construct_pre_destory.xml");

        ((ClassPathXmlApplicationContext) ctx).destroy();

    }
}
