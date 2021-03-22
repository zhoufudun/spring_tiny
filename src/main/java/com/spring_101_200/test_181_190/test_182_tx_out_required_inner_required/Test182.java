package com.spring_101_200.test_181_190.test_182_tx_out_required_inner_required;




import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test182 {



    @Test
    public void updateUserRequiresNewTest19() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_101_200/config_181_190/spring182_spring_mybatis/spring182.xml");
        TxService txService =(TxService)ac.getBean("txService");
        txService.updateUserRequiresNewTest19();
    }





}
