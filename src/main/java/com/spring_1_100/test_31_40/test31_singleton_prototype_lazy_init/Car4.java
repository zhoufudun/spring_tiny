package com.spring_1_100.test_31_40.test31_singleton_prototype_lazy_init;

import lombok.Data;

@Data
public class Car4 {
    private Long id ;
    private String brand;
    private int maxSpeed;

    public Car4() {
        System.out.println("car 4 实例化");
    }
}
