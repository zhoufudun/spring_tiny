package com.spring_1_100.test_61_70.test65_2;

import org.springframework.stereotype.Service;

@Service
public class AserviceImpl {

    public String a() {
        System.out.println("print a ");
        return "a";
    }

    public String b(String x, String y) {
        System.out.println("print x=" + x + ",y=" + y);
        return "b";
    }
}
