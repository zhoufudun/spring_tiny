package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1124;

public class Run {
    //  说明方法join()与interupt()方法如果彼此遇到，则会抛出异常，但进程按钮还是呈现红色，原因 是线程ThreadA 还在继续执行，线程A
    // 并款出现异常情况，是正常的执行状态
    public static void main(String[] args) throws Exception {
        ThreadB b = new ThreadB();
        b.start();
        Thread.sleep(500);
        ThreadC c = new ThreadC(b);
        c.start();
    }
}
