package com.spring_101_200.test_151_160.test_159_tx_out_required_inner_required_exception;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test159 {



    // spring_101_200/config_161_170/spring161.xml



    //5========[required[required-exception]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresTest1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_151_160/spring159_tx_out_required_inner_required_exception/spring159.xml");
        TxService txService = ac.getBean(TxService.class);
        txService.updateUserRequiresTest1();
    }

}
