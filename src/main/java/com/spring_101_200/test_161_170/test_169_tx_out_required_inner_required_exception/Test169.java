package com.spring_101_200.test_161_170.test_169_tx_out_required_inner_required_exception;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test169 {



    // spring_101_200/config_161_170/spring161.xml


    //15========[none[mandatory]]=====result:[commit[exception]]=========================================
    @Test
    public void updateUserRequiresNewTest12() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_161_170/spring169.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest12();
    }


}
