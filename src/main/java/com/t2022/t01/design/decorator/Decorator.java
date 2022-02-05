package com.t2022.t01.design.decorator;

public abstract class Decorator  implements  Component{

    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}
