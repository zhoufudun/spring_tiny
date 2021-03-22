package com.spring_101_200.test_161_170.test_168_tx_out_requires_new_inner_mandatory;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test168 {



    // spring_101_200/config_161_170/spring161.xml

    //14.========[requires_new[mandatory]]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest11() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_161_170/spring168.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest11();
    }

}
