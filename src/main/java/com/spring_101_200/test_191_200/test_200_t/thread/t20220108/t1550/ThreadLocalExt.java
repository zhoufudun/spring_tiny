package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1550;

public class ThreadLocalExt extends ThreadLocal {

    @Override
    protected Object initialValue() {
        return "我是默认值";
    }
}
