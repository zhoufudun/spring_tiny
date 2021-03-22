package com.spring_101_200.test_121_130.test_121_this.this1.impl;

import com.spring_101_200.test_121_130.test_121_this.this1.User;
import com.spring_101_200.test_121_130.test_121_this.this1.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser() {
        System.out.println("getUser");
        return null;
    }
}
