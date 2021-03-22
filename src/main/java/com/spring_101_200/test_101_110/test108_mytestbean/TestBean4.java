package com.spring_101_200.test_101_110.test108_mytestbean;

import org.springframework.beans.factory.annotation.Autowired;

public class TestBean4 {

    private DataSource mysqlDataSource;

    private DataSource oracleDataSource;

    @Autowired
    public void initDataSource(@DataSourceType(ip="localhost",database=DataBase.MYSQL) DataSource mysqlDataSource,
                               @DataSourceType(ip="localhost",database=DataBase.ORACLE) DataSource oracleDataSource){
        this.mysqlDataSource = mysqlDataSource;
        this.oracleDataSource = oracleDataSource;
    }

    public DataSource getMysqlDataSource() {
        return mysqlDataSource;
    }

    public DataSource getOracleDataSource() {
        return oracleDataSource;
    }


}
