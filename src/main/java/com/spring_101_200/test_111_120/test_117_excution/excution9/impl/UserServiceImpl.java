package com.spring_101_200.test_111_120.test_117_excution.excution9.impl;

import com.spring_101_200.test_111_120.test_117_excution.excution9.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService, java.io.Serializable {

    @Override
    public void testException(Date date) throws Exception {
        System.out.println("testException " + date);
    }
}




