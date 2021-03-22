package com.spring_1_100.test_61_70.test64_2.impl;

import com.spring_1_100.test_61_70.test64_2.Car;
import org.springframework.stereotype.Service;

@Service
public class TuoLaJiImpl implements Car {
    @Override
    public void driver() {
        System.out.println("开拖拉机");
    }
}
