package com.spring_1_100.test_11_20.test13_constructor_cycle_refrence;

public class Car {

    private Boss boss;

    public Car(Boss boss) {
        this.boss = boss;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}
