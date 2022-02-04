package com.t2022.t01.design.abstractfactory;

public class OracleCommand implements  ICommand {
    @Override
    public void command() {
        System.out.println("oracle command ..");
    }
}
