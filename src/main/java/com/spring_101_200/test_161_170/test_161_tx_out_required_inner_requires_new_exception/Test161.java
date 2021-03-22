package com.spring_101_200.test_161_170.test_161_tx_out_required_inner_requires_new_exception;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test161 {


    //spring_101_200/config_171_180/spring161.xml

    //7========[requires_new-exception[required]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresNewTest3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_161_170/spring161.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest3();
    }

}
