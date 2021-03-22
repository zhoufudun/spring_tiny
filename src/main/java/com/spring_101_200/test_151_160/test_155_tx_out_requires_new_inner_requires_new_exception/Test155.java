package com.spring_101_200.test_151_160.test_155_tx_out_requires_new_inner_requires_new_exception;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test155 {











    //========[requires_new[requires_new-exception]]=====result:[rollback[rollback]]========================
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_151_160/spring155_tx_requires_new_requires_new_exception/spring155.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest1();
    }









}

