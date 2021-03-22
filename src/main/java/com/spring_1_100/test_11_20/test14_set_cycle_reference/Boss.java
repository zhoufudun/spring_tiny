package com.spring_1_100.test_11_20.test14_set_cycle_reference;

public class Boss {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
