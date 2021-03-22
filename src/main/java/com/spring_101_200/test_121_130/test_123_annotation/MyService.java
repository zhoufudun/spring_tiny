package com.spring_101_200.test_121_130.test_123_annotation;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    @MyAnnotation
    public void select(){
        System.out.println("---------select-------");
    }
}
