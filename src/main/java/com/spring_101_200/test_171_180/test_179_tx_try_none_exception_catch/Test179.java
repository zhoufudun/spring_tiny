package com.spring_101_200.test_171_180.test_179_tx_try_none_exception_catch;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test179 {



    // spring_101_200/config_161_170/spring161.xml


    //25========[required try{[none-exception]}catch ]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest20() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_171_180/spring179.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest20();
    }
}
