package com.spring_101_200.test_151_160.test_156_tx_out_requires_new_exception_inner_requires_new;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test156 {

    //========[requires_new-exception[requires_new]]=====result:[rollback[commit]]========================
    @Test
    public void updateUserRequiresNewTest2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_151_160/spring156_tx_requires_new_exception_inner_requires_new/spring156.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest2();
    }

}
