package com.t2022.t01.design.strategy;

public class StepByStepMove implements  Moveable {
    @Override
    public void move() {
        System.out.println("一步一步的移动 ");
    }
}
