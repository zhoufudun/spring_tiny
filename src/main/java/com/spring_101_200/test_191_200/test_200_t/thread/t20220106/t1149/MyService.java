package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1149;

import java.util.concurrent.atomic.AtomicLong;

public class MyService {

    public static AtomicLong aiRef = new AtomicLong(0);

    public void addNum(){
        System.out.println(Thread.currentThread().getName() + " 加了100之后的值是 ：" + aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }

}
