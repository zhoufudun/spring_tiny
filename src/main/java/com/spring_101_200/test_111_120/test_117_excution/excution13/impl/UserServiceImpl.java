package com.spring_101_200.test_111_120.test_117_excution.excution13.impl;

import com.spring_101_200.test_111_120.test_117_excution.excution13.User;
import com.spring_101_200.test_111_120.test_117_excution.excution13.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser() {
        System.out.println("getUser");
        return null;
    }

    @Override
    public int getAge() {
        System.out.println("getAge");
        return 0;
    }


}




