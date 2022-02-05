package com.t2022.t01.design.strategy;

public class StrategyTest {

    public static void main(String[] args) {
        Zombie zombie = new NormalZombie();
        zombie.display();
        zombie.attack();
        zombie.move();




        zombie.setAttackable(new HitAttack());
        zombie.attack();




    }
}
