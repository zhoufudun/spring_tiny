package com.spring_1_100.test_1_10.test.service.impl;

import com.spring_1_100.test_1_10.test.service.UserService;
import org.springframework.beans.factory.InitializingBean;


public class UserServiceImpl implements UserService , InitializingBean {

    public void query() {
        System.out.println(" user query ");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("userServiceImpl afterPropertiesSet ");
    }
}
