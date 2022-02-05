package com.t2022.t01.design.decorator;

public class DecoratorTest {


    public static void main(String[] args) {
        Component component = new ConcreteComponent1(new ConcreteComponent2(new ConcreteComponent()));
        component.operation();
    }
}
