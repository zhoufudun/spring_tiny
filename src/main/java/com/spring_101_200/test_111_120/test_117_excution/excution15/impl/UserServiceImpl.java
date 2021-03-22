package com.spring_101_200.test_111_120.test_117_excution.excution15.impl;

import com.spring_101_200.test_111_120.test_117_excution.excution15.UserService;
import com.spring_1_100.test_61_70.test64_2.MyAnnotation;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {



    @Override
    public void getUser(@MyAnnotation String userName, @MyAnnotation String password) {
        System.out.println("userName :" + userName + ",password :" + password);
    }

    @Override
    public int getAge(String userName, @MyAnnotation String password) {
        System.out.println("userName :" + userName + ", age = " + 10);
        return 1;
    }

}




