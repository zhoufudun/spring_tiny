package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1503;

public class RunTest {


    // 锁非this对象具有一定的优点，如果在一个类中有很多的synchronized方法，这时虽然能实现同步，但会受到阻塞，所以会影响运行效率，但
    //如果使用同步代码块锁定非this对象，则synchronized(非this)代码块中的程序与同步方法是异步的，不与其他的锁this同步方法争抢this锁
    // 则可以大大的提高运行效率
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();


        ThreadA b = new ThreadA(service);
        b.setName("B");
        b.start();

    }
}
