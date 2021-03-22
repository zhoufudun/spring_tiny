package com.spring_1_100.test_91_100.test91_introduction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test91 {


    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        IWaitingProxy iWaitingProxy = ac.getBean(IWaitingProxy.class);
        iWaitingProxy.method();
        IDeclareParentProxy iDeclareParentProxy = (IDeclareParentProxy) iWaitingProxy;
        iDeclareParentProxy.declareParentProxy();
    }


    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_1_100/config_91_100/spring91_introduction/spring91_introduction1.xml");
        IWaitingProxy iWaitingProxy = ac.getBean(IWaitingProxy.class);
        iWaitingProxy.method();
        IDeclareParentProxy iDeclareParentProxy = (IDeclareParentProxy) iWaitingProxy;
        iDeclareParentProxy.declareParentProxy();
    }


    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_1_100/config_91_100/spring91_introduction/spring91_introduction2.xml");
        IWaitingProxy iWaitingProxy = ac.getBean(IWaitingProxy.class);
        iWaitingProxy.method();
        IDeclareParentProxy iDeclareParentProxy = (IDeclareParentProxy) iWaitingProxy;
        iDeclareParentProxy.declareParentProxy();
    }

}
