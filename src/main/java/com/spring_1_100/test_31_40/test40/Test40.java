package com.spring_1_100.test_31_40.test40;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test40 {
    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring40.xml");

        System.out.println(JSON.toJSONString(bf.getBean("user")));

    }
}



