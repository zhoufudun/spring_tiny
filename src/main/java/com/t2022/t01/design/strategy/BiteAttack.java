package com.t2022.t01.design.strategy;

public class BiteAttack implements  Attackable {


    @Override
    public void attack() {
        System.out.println("咬");
    }
}


