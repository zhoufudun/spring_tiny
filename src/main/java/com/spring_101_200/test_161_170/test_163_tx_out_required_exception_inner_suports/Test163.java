package com.spring_101_200.test_161_170.test_163_tx_out_required_exception_inner_suports;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test163 {


    // spring_101_200/config_161_170/spring161.xml



    //9========[required-exception[supports]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresNewTest5() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_161_170/spring163.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest5();
    }



}
