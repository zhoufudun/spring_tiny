package com.spring_101_200.test_101_110.test109_ignore_depency;


import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void get() {
        System.out.println("瞿贻晓");
    }
}
