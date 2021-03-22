package com.spring_101_200.test_171_180.test_175_tx_out_never_inner_required;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test175 {

    // spring_101_200/config_161_170/spring161.xml





    //21========[never[required]]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest17() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_171_180/spring175.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest17();
    }




}
