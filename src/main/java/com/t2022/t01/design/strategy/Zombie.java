package com.t2022.t01.design.strategy;

import lombok.Data;

@Data
public abstract  class Zombie {
    abstract public void display();
    Moveable moveable;
    Attackable attackable;


    public Zombie(Moveable moveable, Attackable attackable) {
        this.moveable = moveable;
        this.attackable = attackable;
    }


    abstract  void move();
    abstract  void attack();


}
