package com.spring_1_100.test_31_40.test36_prototype;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class Car {
    private String brand;
    private int maxSpeed;
    private double price ;

}
