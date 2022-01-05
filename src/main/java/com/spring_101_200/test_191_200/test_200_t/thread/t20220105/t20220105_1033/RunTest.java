package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1033;

public class RunTest {

    // 为了让结果体现随机性，所以两个线程的优先级别一个设计为5 ，另外一个设置为6，让优先级接近一些
    // 那么，根据些实验可以得出一个结论，不要把线程的优先级别与运行结果的顺序作为衡量的标准，优先级较高的线程并不一定每一次都先执行完
    // run()方法中的任务，也就是说，线程优先级与打印顺序无关，不要将这两者之间的相关联，它们的关系具有不确定性和随机性。
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread1 thread1 = new MyThread1();
            thread1.setPriority(5);
            thread1.start();
            MyThread2 thread2 = new MyThread2();
            thread2.setPriority(6);
            thread2.start();

        }
    }
}
