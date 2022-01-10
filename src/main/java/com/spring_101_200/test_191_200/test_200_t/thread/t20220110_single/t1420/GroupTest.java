package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1420;

public class GroupTest {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程A");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程B");
            }
        });


        ThreadGroup group = new ThreadGroup("线程组");
        Thread tt = new Thread(group, t);
        Thread tt2 = new Thread(group, t2);
        tt.start();
        tt2.start();
        System.out.println("活动线程数为：" + group.activeCount());
        System.out.println("线程的名称为：" + group.getName());

    }
}
