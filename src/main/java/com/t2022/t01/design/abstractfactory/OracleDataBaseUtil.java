package com.t2022.t01.design.abstractfactory;

public class OracleDataBaseUtil implements IDatabaseUtils {
    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}
