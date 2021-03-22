package com.spring_101_200.test_111_120.test_114_conversion2;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test114 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_101_200/config_111_120/spring114_conversion2/spring114.xml");
        User user = (User) ctx.getBean("user");
        System.out.println(JSON.toJSONString(user));
    }

}
