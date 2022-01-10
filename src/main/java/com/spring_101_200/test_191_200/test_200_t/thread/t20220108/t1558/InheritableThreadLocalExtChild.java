package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1558;

import java.util.Date;

public class InheritableThreadLocalExtChild extends InheritableThreadLocal {


    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }


    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + " 我是子线程加的~ ";
    }
}
