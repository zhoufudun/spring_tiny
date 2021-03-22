package com.spring_1_100.test_81_90.test83_property_editor;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test83 {
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_81_90/spring83_property_editor.xml");

        Boss boss = (Boss) ctx.getBean("boss");
        System.out.println(JSON.toJSONString(boss));

    }
}
