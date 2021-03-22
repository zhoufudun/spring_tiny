package com.spring_101_200.test_101_110.test108_mytestbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TestBean {

	private DataSource dataSource;


	@Autowired
	@Qualifier(value="oracleDataSource")
	public void initDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}


	/*
	@Autowired
	public void initDataSource(@Qualifier("oracleDataSource") DataSource dataSource) {
		this.dataSource = dataSource;
	}
*/


	public DataSource getDataSource() {
		return dataSource;
	}

}
