package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1553;

import java.util.Date;

public class ThreadLocalExt extends ThreadLocal {

    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }
}
