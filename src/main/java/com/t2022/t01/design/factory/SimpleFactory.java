package com.t2022.t01.design.factory;


public class SimpleFactory {

    public static Product createProduct(String type ){
        if("0".equals(type)){
            return new ProductA();
        }else if ("1".equals(type)){
            return new ProductB();
        }
        return null;
    }



}
