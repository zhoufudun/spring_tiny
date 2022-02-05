package com.t2022.t01.design.strategy;

public class FlagZombie extends  Zombie {


    public FlagZombie() {
        super(new StepByStepMove(),new BiteAttack());
    }

    public FlagZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是旗手僵尸");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attackable.attack();
    }
}
