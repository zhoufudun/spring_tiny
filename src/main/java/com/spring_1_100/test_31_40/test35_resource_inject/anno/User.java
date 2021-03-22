package com.spring_1_100.test_31_40.test35_resource_inject.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("xxxx")
@MyTestAnnotation("/user/info")
public class User {
    @Autowired
    private Car car;

    @Autowired
    private Dog dog;


    public void drive(){
        System.out.println(car);
    }
}
