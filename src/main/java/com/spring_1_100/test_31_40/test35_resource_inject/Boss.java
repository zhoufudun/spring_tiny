package com.spring_1_100.test_31_40.test35_resource_inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Boss {

    @Autowired
    private Car car ;


    public Car getCar() {
        return car;
    }
}
