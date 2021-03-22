package com.spring_101_200.test_111_120.test_118_within.within2.impl;

import com.spring_101_200.test_111_120.test_118_within.within2.User;
import com.spring_101_200.test_111_120.test_118_within.within2.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser() {
        System.out.println("getUser");
        return null;
    }
}
