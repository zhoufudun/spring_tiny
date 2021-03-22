package com.spring_1_100.test_61_70.test64_2.impl;

import com.spring_1_100.test_61_70.test64_2.MyAnnotation;
import com.spring_1_100.test_61_70.test64_2.UserAmount;
import org.springframework.stereotype.Service;

@Service
@MyAnnotation
public class UserAmountImpl implements UserAmount {
    @Override
    public void getAmount() {
        System.out.println("getAmount");
    }
}
