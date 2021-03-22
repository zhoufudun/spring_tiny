package com.spring_1_100.test_21_30.test26_replacer_method;

import com.alibaba.fastjson.JSON;
import com.spring_1_100.test_21_30.test25_lookup_method.MagicBoss;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test26 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_21_30/spring26_replace_method.xml");


        Boss boss = (Boss) ac.getBean("boss");
        Car car = boss.getCar();
        System.out.println(JSON.toJSONString(car));

    }
}
