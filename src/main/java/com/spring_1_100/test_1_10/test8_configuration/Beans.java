package com.spring_1_100.test_1_10.test8_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {


    @Bean(name = "car")
    public Car buildCar(){
        Car car = new Car();
        car.setBrand("红旗 CA72");
        car.setMaxSpeed(200);
        return car;
    }


}
