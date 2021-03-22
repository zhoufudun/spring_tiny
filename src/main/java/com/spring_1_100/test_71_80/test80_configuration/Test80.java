package com.spring_1_100.test_71_80.test80_configuration;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test80 {


    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring80_configuration.xml");
        ServiceConfig serviceConfig = ac.getBean(ServiceConfig.class);
        LogonService logonService = serviceConfig.logonService();
        LogDao logDao = logonService.getLogDao();
        System.out.println(logDao);
    }


    @Test
    public void test2() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        LogDao logDao = ac.getBean(LogDao.class);
        System.out.println(logDao);
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(ServiceConfig.class);
        ac.register(AppConfig.class);
        ac.refresh();
        LogonService logonService = ac.getBean(LogonService.class);
        System.out.println(logonService.getLogDao());

    }


    @Test
    public void test4() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DaoConfig.class);
        LogDao logDao = ac.getBean(LogDao.class);
        System.out.println(logDao);
    }


    @Test
    public void test5() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring80_configuration_add.xml");
        UserDao userDao = ac.getBean(UserDao.class);
        System.out.println(userDao);
        // org.springframework.beans.factory.NoSuchBeanDefinitionException:
        // No qualifying bean of type [com.spring_1_100.test_71_80.test80_configuration.LogonService] is defined
        //LogonService logonService = ac.getBean(LogonService.class);


    }


}
