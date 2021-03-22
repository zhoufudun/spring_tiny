package com.spring_101_200.test_111_120.test_117_excution.excution8.impl;

import com.spring_101_200.test_111_120.test_117_excution.excution8.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {
    @Override
    public void testException(Date date) throws Exception {
        System.out.println("testException " + date);
    }

    @Override
    public void testIllegalArgumentException() throws IllegalArgumentException {
        System.out.println("testIllegalArgumentException ");
    }

}




