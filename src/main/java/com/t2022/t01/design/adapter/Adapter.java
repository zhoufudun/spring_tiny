package com.t2022.t01.design.adapter;

public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int i = adaptee.output220v();
        System.out.println("原始电压 ：%d v-> 输出电压 ：%d " + i);
        return 5;
    }
}
