package com.t2022.t01.design.factory;

public class ConcreateProductA extends Application {
    @Override
    Product createProduct() {
        return new ProductA();
    }


}
