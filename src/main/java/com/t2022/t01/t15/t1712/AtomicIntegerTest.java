package com.t2022.t01.t15.t1712;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private AtomicInteger count = new AtomicInteger();


    public void increment(){
        count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }


}
