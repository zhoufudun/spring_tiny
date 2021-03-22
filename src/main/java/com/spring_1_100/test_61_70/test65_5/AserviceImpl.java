package com.spring_1_100.test_61_70.test65_5;

import org.springframework.stereotype.Service;

@Service
public class AserviceImpl {

    public AserviceImpl b(String x, User y) {
        System.out.println("print x=" + x + ",y=" + y);
        return this;
    }
}
