package com.spring_101_200.test_101_110.test109_ignore_depency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {

    @Autowired
    private SpringContextUtils springContextUtils;


    public void test() {
        System.out.println(springContextUtils.getApplicationContext());
        UserService userService = springContextUtils.getApplicationContext().getBean(UserService.class);
        userService.get();
    }


}
