package com.spring_1_100.test_21_30.test21_map_attr;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test21 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_21_30/spring21_map_attr.xml");
        Boss boss = (Boss) ac.getBean("boss");
        System.out.println(JSON.toJSONString(boss));


        Boss boss2 = (Boss) ac.getBean("boss2");
        System.out.println(JSON.toJSONString(boss2));
    }
}
