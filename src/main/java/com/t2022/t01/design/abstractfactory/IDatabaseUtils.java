package com.t2022.t01.design.abstractfactory;

public interface IDatabaseUtils {

    IConnection getConnection();

    ICommand getCommand();




}
