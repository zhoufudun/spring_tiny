package com.spring_101_200.test_171_180.test_177_tx_required_try_catch;




import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test177 {

    //23========required [try{ 1 ,exception, 2 }catch] =====result:[commit , not run]=========================================
    //========required [try{ 1 , 2 ,exception }catch] =====result:[commit , commit]=========================================
    @Test
    public void updateUserRequiresNewTest19() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_171_180/spring177.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest19();
    }

}
