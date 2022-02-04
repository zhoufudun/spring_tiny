package com.t2022.t01.design.abstractfactory;

public class MysqlDataBaseUtil implements  IDatabaseUtils {
    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}


