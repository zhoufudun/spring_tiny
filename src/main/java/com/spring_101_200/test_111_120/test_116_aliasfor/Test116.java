package com.spring_101_200.test_111_120.test_116_aliasfor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test116 {

    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = ac.getBean(UserService.class);
        userService.test();
    }
}
