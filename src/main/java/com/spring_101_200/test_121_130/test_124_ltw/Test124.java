package com.spring_101_200.test_121_130.test_124_ltw;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test124 {

    @Test
    public void a (){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_121_130/spring_124_lwt.xml");

        UserService myService =(UserService) ac.getBean("userService");
        myService.a();
    }

}
