package com.spring_101_200.test_161_170.test_166_tx_out_required_inner_supports_exception;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test166 {



    // spring_101_200/config_161_170/spring161.xml


    //12========[required[supports-exception]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresNewTest8() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_161_170/spring166.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest8();
    }
}
