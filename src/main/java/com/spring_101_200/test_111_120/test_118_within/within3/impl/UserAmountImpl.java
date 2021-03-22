package com.spring_101_200.test_111_120.test_118_within.within3.impl;

import com.spring_101_200.test_111_120.test_118_within.within3.MyAnnotation;
import com.spring_101_200.test_111_120.test_118_within.within3.UserAmount;
import org.springframework.stereotype.Service;

@Service
@MyAnnotation
public class UserAmountImpl implements UserAmount {
    @Override
    public void getAmount() {
        System.out.println("getAmount");
    }
}
