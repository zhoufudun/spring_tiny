package com.spring_1_100.test_71_80.test79_post_construct_pre_destory;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Car {
    private String brand;
    private int maxSpeed;
    private double price ;

}
