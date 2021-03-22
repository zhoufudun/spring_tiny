package com.spring_1_100.test_71_80.test76_spring_rmi.service;

public class HelloRMIServiceImpl implements HelloRMIService {
    @Override
    public int getAdd(int a, int b) {
        System.out.println(" a = "+ a + " , b = "+ b + ",result = "+ (a + b ));
        return a + b ;
    }
}
