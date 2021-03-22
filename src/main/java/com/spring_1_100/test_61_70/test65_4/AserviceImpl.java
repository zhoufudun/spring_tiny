package com.spring_1_100.test_61_70.test65_4;

import org.springframework.stereotype.Service;

@Service
public class AserviceImpl {

    public String b(String x, User y) {
        System.out.println("print x=" + x + ",y=" + y);
        return "b";
    }
}
