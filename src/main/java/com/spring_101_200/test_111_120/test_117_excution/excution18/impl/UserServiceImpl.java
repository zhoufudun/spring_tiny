package com.spring_101_200.test_111_120.test_117_excution.excution18.impl;


import com.spring_101_200.test_111_120.test_117_excution.excution18.Model;
import com.spring_101_200.test_111_120.test_117_excution.excution18.UserService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void testModel(Map<Model, Model> modelMap, String a) {
        System.out.println("testModel");
    }

    @Override
    public void testModel1(String a, Map<Model, Model> modelMap) {
        System.out.println("testModel1");
    }

    @Override
    public void testModel2(Map modelMap, String a) {
        System.out.println("testModel2");
    }


}




