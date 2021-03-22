package com.spring_101_200.test_171_180.test_176_tx_required_try_catch;




import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test176 {



    // spring_101_200/config_161_170/spring161.xml
    //22========[required try{[nested-exception]}catch ]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest18() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_171_180/spring176.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest18();
    }
}
