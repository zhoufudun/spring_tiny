package com.t2022.t01.design.strategy;

public class HitAttack implements Attackable {
    @Override
    public void attack() {
        System.out.println("打");
    }
}
