package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1627;

public class Run {



    // 运行结果说明 JVM 的根线和组就是system ，再取其父线程组则出现空异常
    public static void main(String[] args) {
        System.out.println("线程：" + Thread.currentThread().getName() + " 所在的线程组名为 ：" + Thread.currentThread().getThreadGroup().getName());


        System.out.println("main 线程所在的线程组父线程组的名称是：" + Thread.currentThread().getThreadGroup().getParent().getName());

        System.out.println("main 线程所在的线程组的父线程组的父线程组的名称是：" + Thread.currentThread().getThreadGroup().getParent().getParent().getName());

    }
}
