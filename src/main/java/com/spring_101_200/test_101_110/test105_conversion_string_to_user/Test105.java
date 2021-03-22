package com.spring_101_200.test_101_110.test105_conversion_string_to_user;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test105 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_101_200/config_101_110/spring105_converse.xml");

        Person person = (Person) ctx.getBean("person");
        System.out.println(JSON.toJSONString(person.getUser()));

    }
}
