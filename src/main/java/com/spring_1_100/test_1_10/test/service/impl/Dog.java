package com.spring_1_100.test_1_10.test.service.impl;

import com.spring_1_100.test_1_10.test.service.Animal;

public class Dog implements Animal {
    @Override
    public void query() {
        System.out.println("dog query");
    }
}
