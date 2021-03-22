package com.spring_101_200.test_111_120.test_119_target.target2.impl;

import com.spring_101_200.test_111_120.test_119_target.target2.Car;
import com.spring_101_200.test_111_120.test_119_target.target2.MyAnnotation;
import org.springframework.stereotype.Service;

@Service
@MyAnnotation
public class TuoLaJiImpl implements Car {
    @Override
    public void driver() {
        System.out.println("开拖拉机");
    }
}
