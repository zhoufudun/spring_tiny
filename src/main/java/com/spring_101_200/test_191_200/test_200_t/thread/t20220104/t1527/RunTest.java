package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1527;

public class RunTest {


    // 由于监视器的对象不同，所以运行结果就是异步的
    // 同步代码块放在非同步synchronized方法中进行声明，并不能保证调用方法的线程执行同步，顺序性，也就是线程调用方法的顺序是无序的。
    // 虽然同步块中的执行顺序是同步的，这样极易脏读 问题

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);

        a.setName("A");
        a.start();


        ThreadB b = new ThreadB(service);

        b.setName("A");
        b.start();
    }
}
