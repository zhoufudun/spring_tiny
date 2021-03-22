package com.spring_101_200.test_101_110.test108_mytestbean;

import org.springframework.beans.factory.annotation.Autowired;

public class TestBean3 {
    @Mysql
    @Autowired
    private DataSource mysqlDataSource;

    private DataSource oracleDataSource;

    @Autowired
    public void initDataSource( @Oracle DataSource oracleDataSource){
        this.oracleDataSource = oracleDataSource;
    }

    public DataSource getMysqlDataSource() {
        return mysqlDataSource;
    }

    public DataSource getOracleDataSource() {
        return oracleDataSource;
    }

}
