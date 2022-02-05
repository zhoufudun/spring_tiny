package com.t2022.t01.design.strategy;

public class NormalZombie extends Zombie {

    public NormalZombie() {
        super(new StepByStepMove(), new BiteAttack());
    }


    public NormalZombie(Moveable moveable, Attackable attackable) {
        super(moveable, attackable);
    }

    @Override
    public void display() {
        System.out.println("我是普通僵尸");
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
