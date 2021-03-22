package com.spring_101_200.test_111_120.test_117_excution.excution19.impl;


import com.spring_101_200.test_111_120.test_117_excution.excution19.UserService;
import com.spring_101_200.test_111_120.test_117_excution.excution19.Model;
import com.spring_101_200.test_111_120.test_117_excution.excution19.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void testMyCollection(Collection<User> users) {
        System.out.println("testMyCollection");
    }


    @Override
    public void testMyUser(List<User> users) {
        System.out.println("testMyUser");
    }

    @Override
    public void testMyModel(List<Model> models) {
        System.out.println("testMyModel");
    }

}




