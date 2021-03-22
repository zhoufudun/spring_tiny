package com.spring_1_100.test_11_20.test11_var_name;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test11 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_11_20/spring11_var_name.xml");
        Foo foo = (Foo) ac.getBean("foo");
        System.out.println(foo.getiDCode());

    }
}
