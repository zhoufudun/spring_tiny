package com.spring_1_100.test_91_100.test94_target;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test94 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_91_100/spring94_target.xml");
        Waiter waiter = (Waiter)ctx.getBean("naiveWaiter");
        waiter.greetTo("John");
        waiter.serviceTo("John");
        ((Seller) waiter).goods("Beer");
    }


}
