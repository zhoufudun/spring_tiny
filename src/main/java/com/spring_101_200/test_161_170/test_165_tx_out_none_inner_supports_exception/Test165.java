package com.spring_101_200.test_161_170.test_165_tx_out_none_inner_supports_exception;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test165 {

    // spring_101_200/config_161_170/spring161.xml

    //11========[none[supports-exception]]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest7() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_161_170/spring165.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest7();
    }
}
