package com.spring_101_200.test_111_120.test_119_target.target1.impl;

import com.spring_101_200.test_111_120.test_119_target.target1.User;
import com.spring_101_200.test_111_120.test_119_target.target1.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser() {
        System.out.println("getUser");
        return null;
    }
}
