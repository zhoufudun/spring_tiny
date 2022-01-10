package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1640;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class Run {


    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup groupA = new ThreadGroup(mainGroup, "A");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runMethod !");
                Utils.sleep(10000);
            }
        };
        ThreadGroup groupB = new ThreadGroup(groupA, "B");
        // 分配空间，但不一定全部用完
        ThreadGroup[] listGroup1 = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        //传入true是递归取得子级及子孙组
        Thread.currentThread().getThreadGroup().enumerate(listGroup1, true);
        for (int i = 0; i < listGroup1.length; i++) {
            if (listGroup1[i] != null) {
                System.out.println(listGroup1[i].getName());
            }
        }
        System.out.println("--------------------------");
        ThreadGroup[] listGroup2 = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(listGroup2, false);
        System.out.println(listGroup2.length);
        for (int i = 0; i < listGroup2.length; i++) {
            if (listGroup2[i] != null) {
                System.out.println(listGroup2[i].getName());
            }
        }

    }
}
