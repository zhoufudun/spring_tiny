package com.t2022.t01.design.decorator;

public class ConcreteComponent2  extends  Decorator{
    public ConcreteComponent2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加滤镜");
        component.operation();
    }
}
