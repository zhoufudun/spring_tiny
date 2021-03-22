package com.spring_1_100.test_11_20.test13_constructor_cycle_refrence;

public class Boss {
    private Car car;

    public Boss(Car car) {

        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
