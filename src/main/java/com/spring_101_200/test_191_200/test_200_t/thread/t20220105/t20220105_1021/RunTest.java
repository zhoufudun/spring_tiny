package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1021;

public class RunTest {
    // 大部分的thread1 先执行完，也就验证了线程的优先级也代码执行顺序无关，出现这样的结果是因为MyThread2的优先级是最高的，说明线程的
    // 优先级别具有一定的规则性，也就是CPU尽量将执行资源让优先级较高的线程。
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread1 thread1 = new MyThread1();
            thread1.setPriority(10);
            thread1.start();
            MyThread2 thread2 = new MyThread2();
            thread2.setPriority(1);
            thread2.start();

        }
    }
}
