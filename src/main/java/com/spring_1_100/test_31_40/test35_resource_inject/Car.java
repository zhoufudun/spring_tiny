package com.spring_1_100.test_31_40.test35_resource_inject;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Car {
    private String brand;
    private int maxSpeed;
    private double price ;

}
