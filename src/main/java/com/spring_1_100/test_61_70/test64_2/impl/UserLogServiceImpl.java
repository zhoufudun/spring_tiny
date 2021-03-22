package com.spring_1_100.test_61_70.test64_2.impl;

import com.spring_1_100.test_61_70.test64_2.UserLogService;
import org.springframework.stereotype.Service;

@Service
public class UserLogServiceImpl implements UserLogService {

    @Override
    public void getLog() {
        System.out.println("get user Log  ");
    }
}
