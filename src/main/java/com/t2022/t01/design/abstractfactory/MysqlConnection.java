package com.t2022.t01.design.abstractfactory;

public class MysqlConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("mysql connected...");
    }
}
