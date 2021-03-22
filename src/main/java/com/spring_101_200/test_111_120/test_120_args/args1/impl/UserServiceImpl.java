package com.spring_101_200.test_111_120.test_120_args.args1.impl;


import com.spring_101_200.test_111_120.test_120_args.args1.Model;
import com.spring_101_200.test_111_120.test_120_args.args1.User;
import com.spring_101_200.test_111_120.test_120_args.args1.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public void testArgs2(Model model, String a) {
        System.out.println("testArgs2");
    }

    @Override
    public User getUser() {
        System.out.println("getUser");
        return null;
    }

}
