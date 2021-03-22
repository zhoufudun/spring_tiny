package com.spring_1_100.test_61_70.test64_2;

import org.springframework.stereotype.Service;

@Service
public class MyService {


    public void service(){
        System.out.println("---------serivce");
    }



    @MyAnnotation
    public void select(){
        System.out.println("---------select-------");
    }
}
