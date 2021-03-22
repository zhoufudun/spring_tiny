package com.spring_101_200.test_111_120.test_117_excution.excution16.impl;

import com.spring_101_200.test_111_120.test_117_excution.excution16.MyAnnotation;
import com.spring_101_200.test_111_120.test_117_excution.excution16.User;
import com.spring_101_200.test_111_120.test_117_excution.excution16.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public int getAge(String userName, @MyAnnotation String password) {
        System.out.println("userName :" + userName + ", age = " + 10);
        return 1;
    }

    @Override
    public void getUserInfo(User user) {
        System.out.println("getUserInfo :");
    }

}




