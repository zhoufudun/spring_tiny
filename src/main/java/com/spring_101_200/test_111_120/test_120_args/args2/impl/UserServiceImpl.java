package com.spring_101_200.test_111_120.test_120_args.args2.impl;


import com.spring_101_200.test_111_120.test_120_args.args2.Model;
import com.spring_101_200.test_111_120.test_120_args.args2.User;
import com.spring_101_200.test_111_120.test_120_args.args2.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {



    @Override
    public void testArgs1(Model model) {
        System.out.println("testArgs1");
    }

    @Override
    public void getUserInfo(User user) {
        System.out.println("getUserInfo :");
    }


}
