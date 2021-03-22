package com.spring_1_100.test_71_80.test73_jdbc_transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test73 {
    public static void main(String[] args) throws Exception{

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring73.xml");

        UserService userService = (UserService) ac.getBean("userService");


        User user = new User();
        user.setManagerId(1l);
        user.setPassword("1239832");
        user.setUsername("zhangsan");
        user.setRealName("瞿贻晓");

        userService.save(user);

    }

}
