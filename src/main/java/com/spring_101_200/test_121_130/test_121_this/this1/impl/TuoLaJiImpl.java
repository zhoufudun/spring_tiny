package com.spring_101_200.test_121_130.test_121_this.this1.impl;

import com.spring_101_200.test_121_130.test_121_this.this1.Car;
import org.springframework.stereotype.Service;

@Service
public class TuoLaJiImpl implements Car {
    @Override
    public void driver() {
        System.out.println("开拖拉机");
    }
}
