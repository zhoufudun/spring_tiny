package com.spring_1_100.test_61_70.test61;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

public class Test61 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring61.xml");

        Object[] params = {"test", new GregorianCalendar().getTime()};

        String str1 = ac.getMessage("test", params, Locale.US);
        String str2 = ac.getMessage("test", params, Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);

    }
}
