package com.t2022.t01.design.abstractfactory;

public class OracleConnection implements IConnection {


    @Override
    public void connect() {
        System.out.println("oracle connection.");
    }
}
