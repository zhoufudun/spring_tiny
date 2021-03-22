package com.spring_101_200.test_171_180.test_171_tx_out_required_not_supported_exception;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test171 {



    // spring_101_200/config_171_180/spring161.xml





    //17 不同数据========[required[not_supported-exception]]=====result:[rollback[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest14() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_171_180/spring171.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest14();
    }



}
