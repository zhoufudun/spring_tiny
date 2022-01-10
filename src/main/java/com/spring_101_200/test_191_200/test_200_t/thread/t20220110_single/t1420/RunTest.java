package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1420;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class RunTest {

    public static void main(String[] args) {
        // 在main 组中添加一个线程组A , 然后在这个A 组中添加线程对象Z
        // 方法activeGroupCount() 和 activeCount（） 的值不是固定值
        // 是系统中环境的一个快照
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup group = new ThreadGroup(mainGroup, "A");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runMethod ! ");
                Utils.sleep(10000); // 线程必须在运行状态才可以受组管理
            }
        };

        Thread newThread = new Thread(group, runnable);
        newThread.setName("Z");
        newThread.start();// 线程必须启动然后才归到组A中


        ThreadGroup[] listGroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(listGroup);
        System.out.println("main线程中有多少个子线程 " + listGroup.length + " 名字为 " + listGroup[0].getName());

        Thread[] listThread = new Thread[listGroup[0].activeCount()];
        listGroup[0].enumerate(listThread);
        System.out.println(listThread[0].getName());


    }

}
