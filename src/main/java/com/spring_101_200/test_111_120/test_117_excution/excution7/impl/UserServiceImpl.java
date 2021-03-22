package com.spring_101_200.test_111_120.test_117_excution.excution7.impl;

import com.spring_101_200.test_111_120.test_117_excution.excution7.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public void testBirth(Date date) {
        System.out.println(" testBirth :" + date);
    }

    @Override
    public void testObject(Object object) {
        System.out.println(" object :" + object);
    }

}




