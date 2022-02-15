package com.t2022.t01.t14;

public class VolatileFeaturesExample {


    volatile long v1 = 0l;                  //使用volatile声明64位的long型变量

    public void set(long l) {
        v1 = l;                                 //单个volatile变量写
    }

    public void getAndIncrement() {                                //复合（多个）volatile变量读/写
        v1++;
    }

    public long get() {                             // 单个volatile变量读
        return v1;
    }


}
