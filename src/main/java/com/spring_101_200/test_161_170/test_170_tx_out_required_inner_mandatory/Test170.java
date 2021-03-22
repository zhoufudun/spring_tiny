package com.spring_101_200.test_161_170.test_170_tx_out_required_inner_mandatory;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test170 {



    // spring_101_200/config_161_170/spring161.xml

    //16========[required][mandatory]=====result:[commit][exception]=========================================
    @Test
    public void updateUserRequiresNewTest13() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_161_170/spring170.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest13();
    }



}
