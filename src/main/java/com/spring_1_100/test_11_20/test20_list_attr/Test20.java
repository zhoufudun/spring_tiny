package com.spring_1_100.test_11_20.test20_list_attr;


import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test20 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_11_20/spring20_list_attr.xml");
        Boss boss = (Boss) ac.getBean("boss");
        System.out.println(JSON.toJSONString(boss));



        Boss childBoss = (Boss) ac.getBean("childBoss");
        System.out.println(JSON.toJSONString(childBoss));

    }
}
