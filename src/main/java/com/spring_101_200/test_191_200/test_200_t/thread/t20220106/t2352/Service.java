package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t2352;

public class Service {

    public void testMehtod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait()");
                lock.wait();
                System.out.println("end wait()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //begin wait()
    //java.lang.InterruptedException
    //	at java.lang.Object.wait(Native Method)
    //	at java.lang.Object.wait(Object.java:502)
    //	at com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t2352.Service.testMehtod(Service.java:9)
    //	at com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t2352.ThreadA.run(ThreadA.java:14)
    // 1)执行完同步代码块就会释放对象的锁
    // 2)执行同步代码块的过程中，遇到异常而导致线程终止，锁也会被释放掉
    // 3)执行同步代码块的过程中，执行了锁所属对象的wait()方法，这个线程会释放对象锁，而引线程对象会进入线程等待池中等待被唤醒
    public static void main(String[] args) throws Exception {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();


        Thread.sleep(5000);
        a.interrupt();
    }
}
