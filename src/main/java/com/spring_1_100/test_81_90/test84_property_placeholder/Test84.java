package com.spring_1_100.test_81_90.test84_property_placeholder;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test84 {
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_81_90/spring84_property_placeholder/spring84_property_placeholder.xml");
        MyDataSource myDataSource = ctx.getBean(MyDataSource.class);
        System.out.println(myDataSource);
    }
}
