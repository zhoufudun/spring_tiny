package com.spring_1_100.test_51_60.test51;


import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl1 implements UserService {
    @Override
    public String getUserName() {
        return "userName1";
    }
}
