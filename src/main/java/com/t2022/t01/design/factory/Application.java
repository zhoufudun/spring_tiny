package com.t2022.t01.design.factory;

public abstract class Application {


    abstract Product createProduct();

    public Product getObject() {
        return createProduct();
    }


}
