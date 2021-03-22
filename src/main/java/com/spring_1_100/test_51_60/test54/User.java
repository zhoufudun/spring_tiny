package com.spring_1_100.test_51_60.test54;

import org.springframework.beans.factory.InitializingBean;

public class User implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSEt ");
    }
}
