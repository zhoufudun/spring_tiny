package com.spring_101_200.test_111_120.test_117_excution.excution21.impl;

import com.spring_101_200.test_111_120.test_117_excution.excution21.MyAnnotation;
import com.spring_101_200.test_111_120.test_117_excution.excution21.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Override
    @MyAnnotation(value = "1")
    public int getAge() {
        System.out.println("getAge");
        return 0;
    }

}




