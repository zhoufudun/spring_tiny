package com.spring_1_100.test_81_90.test89_auto_proxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test89 {


    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring89_auto_proxy.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");
        waiter.serviceTo("John");
        waiter.greetTo("John");
        seller.greetTo("Tom");


    }


}
