package com.spring_101_200.test_151_160.test_160_tx_out_required_exception_inner_required;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test160 {


    // spring_101_200/config_161_170/spring161.xml

    //6========[required-exception[required]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresTest2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_151_160/spring160.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresTest2();
    }


}
