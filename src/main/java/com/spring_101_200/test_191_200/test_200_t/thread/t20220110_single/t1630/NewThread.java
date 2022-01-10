package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1630;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class NewThread extends Thread {


    public NewThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        System.out.println("ThreadName=" + Thread.currentThread().getName() + " 准备开始死循环了");
        while (!this.isInterrupted()) {
        }
        System.out.println("ThreadName =" + Thread.currentThread().getName() + " 结束了 ！");
    }

    // 通过将线程归属的线程组中，当调用 线程组ThreadGroup 的interrupt() 方法时，可以将该组中的所有正在运行的线程批量停止
    public static void main(String[] args) throws Exception {
        ThreadGroup group = new ThreadGroup("我的线程组");
        for (int i = 0; i < 5; i++) {
            NewThread thread = new NewThread(group, "线程" + (i + 1));
            thread.start();
        }
        Utils.sleep(5000);
        group.interrupt();
        System.out.println("调用了interrupt() 方法");
    }
}
