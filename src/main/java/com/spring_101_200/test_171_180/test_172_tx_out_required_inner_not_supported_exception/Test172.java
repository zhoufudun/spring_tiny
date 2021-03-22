package com.spring_101_200.test_171_180.test_172_tx_out_required_inner_not_supported_exception;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test172 {



    //spring_101_200/config_171_180/spring161.xml



    //18 同一条数据========[required[not_supported-exception]]=====result:[程序被挂起，但是内部的not_supported修改的内容被提交]=========================================
    // org.springframework.dao.CannotAcquireLockException: PreparedStatementCallback;
    // SQL [update lz_user set username = ? where id = ? ]; Lock wait timeout exceeded;
    // try restarting transaction; nested exception is java.sql.SQLException:
    // Lock wait timeout exceeded; try restarting transaction
    @Test
    public void updateUserRequiresNewTest144() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_171_180/spring172.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest144();
    }



}
