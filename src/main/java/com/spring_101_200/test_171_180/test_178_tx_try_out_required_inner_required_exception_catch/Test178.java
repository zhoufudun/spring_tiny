package com.spring_101_200.test_171_180.test_178_tx_try_out_required_inner_required_exception_catch;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test178 {



    // spring_101_200/config_161_170/spring161.xml




    //24========[try{required[required-exception]}catch ]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresNewTest21() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_171_180/spring178.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest21();
    }

}
