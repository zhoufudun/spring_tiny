package com.t2022.t01.design.decorator;

public class ConcreteComponent  implements Component{
    @Override
    public void operation() {
        System.out.println("拍照");
    }
}
