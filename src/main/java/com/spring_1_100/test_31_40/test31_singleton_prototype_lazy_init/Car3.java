package com.spring_1_100.test_31_40.test31_singleton_prototype_lazy_init;

import lombok.Data;

@Data
public class Car3 {
    private Long id ;
    private String brand;
    private int maxSpeed;


    public Car3() {
        System.out.println("car 3 实例化");
    }
}
