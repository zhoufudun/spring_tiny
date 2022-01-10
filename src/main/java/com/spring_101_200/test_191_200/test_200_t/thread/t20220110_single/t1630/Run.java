package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1630;

public class Run {
    public static void main(String[] args) {
        System.out.println("线程组名称：" + Thread.currentThread().getThreadGroup().getName());

        System.out.println("线程组上活动的线程数量：" + Thread.currentThread().getThreadGroup().activeCount());

        System.out.println("线程组中线程的数量加之前：" + Thread.currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup newGroup = new ThreadGroup(Thread.currentThread().getThreadGroup(), "NewGroup");

        System.out.println("线程组中线程组的数量-加之之后：" + Thread.currentThread().getThreadGroup().activeGroupCount());
        System.out.println("父线程组名称 ：" + Thread.currentThread().getThreadGroup().getParent().getName());

    }
}
