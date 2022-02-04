package com.t2022.t01.design.abstractfactory;

public class MysqlCommand implements  ICommand {

    @Override
    public void command() {
        System.out.println("mysql command ..");
    }

}
