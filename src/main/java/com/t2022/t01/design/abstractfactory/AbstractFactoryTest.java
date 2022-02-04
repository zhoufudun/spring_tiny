package com.t2022.t01.design.abstractfactory;

public class AbstractFactoryTest {


    public static void main(String[] args) {
        IDatabaseUtils iDatabaseUtils = new MysqlDataBaseUtil();
        IConnection connection = iDatabaseUtils.getConnection();
        connection.connect();
        ICommand command = iDatabaseUtils.getCommand();
        command.command();
    }

}
