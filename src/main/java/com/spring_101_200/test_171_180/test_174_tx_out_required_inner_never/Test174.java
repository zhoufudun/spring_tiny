package com.spring_101_200.test_171_180.test_174_tx_out_required_inner_never;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test174 {




    //20========[required[never]]=====result:[exception : Existing transaction found for transaction marked with propagation 'never']=========================================
    @Test
    public void updateUserRequiresNewTest16() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_171_180/spring174.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest16();
    }

}
