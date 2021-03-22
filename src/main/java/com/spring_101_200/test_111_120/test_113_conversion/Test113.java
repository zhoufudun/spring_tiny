package com.spring_101_200.test_111_120.test_113_conversion;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test113 {


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_101_200/config_111_120/spring113_conversion/spring113.xml");
        Student student = (Student) ctx.getBean("student");
        System.out.println(JSON.toJSONString(student));
    }
}
