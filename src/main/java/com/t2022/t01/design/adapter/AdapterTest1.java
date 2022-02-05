package com.t2022.t01.design.adapter;

public class AdapterTest1 {

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target1 = new Adapter(adaptee);
        target1.output5v();
    }
}
