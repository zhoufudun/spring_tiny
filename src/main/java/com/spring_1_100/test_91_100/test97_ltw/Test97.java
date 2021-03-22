package com.spring_1_100.test_91_100.test97_ltw;

import com.spring_1_100.test_91_100.test97_ltw.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test97 {



    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_91_100/spring97_ltw.xml");
        Waiter waiter = ctx.getBean(Waiter.class);
        String b = waiter.greetTo("John");
    }
}
