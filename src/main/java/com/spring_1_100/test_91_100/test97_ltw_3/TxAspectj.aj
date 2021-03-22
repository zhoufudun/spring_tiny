package com.spring_1_100.test_91_100.test97_ltw_3;

public aspect TxAspectj {

    void around():call(void Hello.sayHello()){
        System.out.println("开始事务...");
        proceed();
        System.out.println("事务结束...");
    }

}
