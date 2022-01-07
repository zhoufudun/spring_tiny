package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1156;

public class Run {



    // 关键字synchronized 可以保证在同一时刻，只有一个线程可以执行某一个方法或某一个代码块，它包含两个特性，互斥性和可见性，同步 synchronized不仅可以解决一个线程
    // 看到对象处于不一致的状态，还可以保证进入同步方法或者同步代码块的每个线程都看到由同一个锁保护之前的所有修改结果
    public static void main(String[] args) throws Exception {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.start();

        Thread.sleep(1000);

        ThreadB b = new ThreadB(service);
        b.start();
        System.out.println("已经发起了停止命令了");
    }
}
