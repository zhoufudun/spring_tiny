package com.spring_101_200.test_151_160.test_158_tx_out_required_inner_requires_new_and_requires_new_exception;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test158 {

    //4========[required[requires_new][requires_new-exception]]=====result:[rollback[commit][rollback]]========================
    @Test
    public void updateUserRequiresNewTest222() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_151_160/spring158_tx_out_required_inner_requires_new_and_requires_new_exception/spring158.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest222();
    }

}
