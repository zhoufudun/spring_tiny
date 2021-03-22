package com.spring_101_200.test_181_190.test_183_tx_required;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test183 {





    @Test
    public void updateUserRequiresNewTest2222() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_181_190/spring183.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest2222();
    }



}
