package com.spring_101_200.test_181_190.test_182_tx_out_required_inner_required;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

public class MyDataSourceTransactionManager extends DataSourceTransactionManager {


    @Override
    protected void doBegin(Object transaction, TransactionDefinition definition) {
        System.out.println("=============开启事务之前================");
        super.doBegin(transaction,definition);
    }

    @Override
    protected void doCommit(DefaultTransactionStatus status) {
        super.doCommit(status);
        System.out.println("=============提交事务之后================");
    }



}
