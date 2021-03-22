package com.spring_1_100.test_11_20.test19_cascade_attr;


import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test19 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_11_20/spring19_cascade_attr.xml");
        Boss boss = ac.getBean(Boss.class);
        System.out.println(JSON.toJSONString(boss));
    }
}
