package com.spring_1_100.test_81_90.test87_aop;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test87 {

    @Test
    public void test1() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        // Spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        //设置代理目标
        pf.setTarget(target);
        // 为代理目标添加增强
        pf.addAdvice(advice);
        //生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serviceTo("Tom");


    }


    @Test
    public void test2() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring87_aop.xml");

        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.serviceTo("quyixiao");
        waiter.greetTo("hukaiming");
    }


    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring87_aop.xml");
        ForumService forumService =(ForumService) ctx.getBean("forumService");
        forumService.eat();
        Monitorable monitorable = (Monitorable)forumService;
        monitorable.setMonitorAdcive(true);
        forumService.eat();
    }

    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_81_90/spring87_aop.xml");
        ForumService forumService =(ForumService) ctx.getBean("forumService2");
        forumService.eat();
    }
}
