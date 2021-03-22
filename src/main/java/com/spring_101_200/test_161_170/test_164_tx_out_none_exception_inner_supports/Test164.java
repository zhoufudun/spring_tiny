package com.spring_101_200.test_161_170.test_164_tx_out_none_exception_inner_supports;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test164 {


    // spring_101_200/config_161_170/spring161.xml

    //10========[none-exception[supports]]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest6() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_161_170/spring164.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest6();
    }
}
