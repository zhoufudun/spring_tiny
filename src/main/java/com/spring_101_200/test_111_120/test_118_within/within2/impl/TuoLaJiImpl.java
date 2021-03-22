package com.spring_101_200.test_111_120.test_118_within.within2.impl;

import com.spring_101_200.test_111_120.test_118_within.within2.Car;
import org.springframework.stereotype.Service;

@Service
public class TuoLaJiImpl implements Car {
    @Override
    public void driver() {
        System.out.println("开拖拉机");
    }
}
