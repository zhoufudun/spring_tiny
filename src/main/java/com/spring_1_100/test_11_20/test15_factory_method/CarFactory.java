package com.spring_1_100.test_11_20.test15_factory_method;


import java.util.Calendar;

public class CarFactory {
    public Car createCar(){
        Car car = new Car();
        car.setBrand("中国");
        return  car;
    }


    public static Car createStaticCar(){
        Car car = new Car();
        car.setBrand("中国");
        return  car;
    }
}
