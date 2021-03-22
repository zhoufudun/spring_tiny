package com.spring_101_200.test_161_170.test_167_tx_out_requires_new_inner_supports_exception;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test167 {

    // spring_101_200/config_161_170/spring161.xml

    //13========[requires_new[supports-exception]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresNewTest9() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_161_170/spring167.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest9();
    }

}
