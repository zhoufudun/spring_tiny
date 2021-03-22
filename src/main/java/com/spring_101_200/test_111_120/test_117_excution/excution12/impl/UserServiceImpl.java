package com.spring_101_200.test_111_120.test_117_excution.excution12.impl;

import com.spring_101_200.test_111_120.test_117_excution.excution12.MyAnnotation;
import com.spring_101_200.test_111_120.test_117_excution.excution12.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Override
    @Deprecated
    public void testDeprecated() {
        System.out.println("testDeprecated ");
    }

    @Override
    @Deprecated
    @MyAnnotation
    public void testDeprecatedMyAnnotation() {
        System.out.println("testDeprecatedMyAnnotation ");
    }

}




