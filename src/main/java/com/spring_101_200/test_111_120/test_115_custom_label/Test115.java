package com.spring_101_200.test_111_120.test_115_custom_label;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test115 {

    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("spring_101_200/config_111_120/spring115_custom_label/spring115.xml");
        User user = (User) bf.getBean("testBean");
        System.out.println(JSON.toJSONString(user));
    }
}
