package com.spring_101_200.test_151_160.test_157_tx_out_required_exception_inner_requires_new;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test157 {

    //3========[required-exception[requires_new]]=====result:[rollback[commit]]========================
    @Test
    public void updateUserRequiresNewTest22() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_151_160/spring157_tx_out_required_exception_inner_requires_new/spring157.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest22();
    }

}
