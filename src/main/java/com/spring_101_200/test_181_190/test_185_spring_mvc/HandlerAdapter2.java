package com.spring_101_200.test_181_190.test_185_spring_mvc;

import org.springframework.core.Ordered;

public class HandlerAdapter2 implements IAdapter, Ordered {

    @Override
    public int getOrder() {
        return 0;
    }
}
