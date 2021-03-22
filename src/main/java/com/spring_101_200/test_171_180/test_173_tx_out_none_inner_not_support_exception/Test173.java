package com.spring_101_200.test_171_180.test_173_tx_out_none_inner_not_support_exception;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test173 {


    // spring_101_200/config_161_170/spring161.xml




    //19========[none[not_supported-exception]]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest15() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_171_180/spring173.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest15();
    }



}
