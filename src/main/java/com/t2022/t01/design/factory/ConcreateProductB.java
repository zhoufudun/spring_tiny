package com.t2022.t01.design.factory;

public class ConcreateProductB extends Application {
    @Override
    Product createProduct() {
        return new ProductB();
    }
}
