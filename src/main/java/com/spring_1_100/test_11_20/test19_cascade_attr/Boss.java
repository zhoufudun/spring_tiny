package com.spring_1_100.test_11_20.test19_cascade_attr;

public class Boss {
    // Invalid property 'car' of bean class [com.spring_1_100.test_11_20.test19_cascade_attr.Boss]: Value of nested property 'car' is null
    // private Car car ;//= new Car(); 这个属性一定要初始化

    private Car car = new Car();
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
