package com.t2022.t01.design.singleton;

public enum EnumSingleton {

    INSTANCE;

    public void print() {
        System.out.println(this.hashCode());
    }



}
