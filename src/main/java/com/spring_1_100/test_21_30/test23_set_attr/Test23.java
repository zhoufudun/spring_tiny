package com.spring_1_100.test_21_30.test23_set_attr;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test23 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_21_30/spring23_set_attr.xml");


        Boss boss2 = (Boss) ac.getBean("childBoss");
        System.out.println(JSON.toJSONString(boss2));


        Boss childBossSet = (Boss) ac.getBean("childBossSet");
        System.out.println(JSON.toJSONString(childBossSet));
    }
}
