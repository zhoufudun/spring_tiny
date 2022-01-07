package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1144;

public class RunTest {

    // 在代码中确实已经通过wait/notify进行通信了，但是不能保证notify唤醒是异类，也许是同类，比如  生产者 唤醒的是 生产者，消费者 唤醒的是
    // 消费者 这样的情况，如果按这样的情况运行的比率积少成多，就会导致所有的线程都不能继续运行下去，大家都在等待，都呈现WAITING状态，
    // 程序最后也就呈假死状态，不能继续运行下去
    // 1) 生产者1进入生产，生产完毕后发出通知（但此通知属于 "通知过早" ,并释放锁，准备进入下一次while(循环)）
    // 2) 行者进入1 进入了下一次while
    public static void main(String[] args) throws Exception {
        String lock = new String("");

        P p = new P(lock);
        C r = new C(lock);
        ThreadP[] threadPS = new ThreadP[2];
        ThreadC[] threadCS = new ThreadC[2];
        for (int i = 0; i < 2; i++) {
            threadPS[i] = new ThreadP(p);
            threadPS[i].setName("生产者 " + (i + 1));
            threadPS[i].start();

            threadCS[i] = new ThreadC(r);
            threadCS[i].setName("消费者 " + (i + 1));
            threadCS[i].start();
        }
        Thread.sleep(5000);
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for (int i = 0; i < threadArray.length; i++) {
            System.out.println(threadArray[i].getName() + " " + threadArray[i].getState());
        }
    }
}
