package com.spring_101_200.test_111_120.test_117_excution.excution22.impl;

import com.spring_101_200.test_111_120.test_117_excution.excution22.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public int getAge(String userName,String password) {
        System.out.println("getAge userName :" + userName + ",password:" + password);
        return 0;
    }

}




