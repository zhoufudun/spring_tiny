package com.t2022.t01.design.decorator;

public class ConcreteComponent1 extends Decorator {
    public ConcreteComponent1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加美颜");
        component.operation();


    }
}
