package com.spring_101_200.test_181_190.test_181_commit_rollback_listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test181 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_181_190/spring181.xml");
        UserService userService = (UserService) ac.getBean("userService");
        userService.updateUserRequiresNew1();
    }

}
