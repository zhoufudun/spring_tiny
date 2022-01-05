package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1445;

public class Run {


    // 在使用同步 synchronized(this) 代码块需要注意的是，当一个线程访问object的一个synchronized(this)同步代码块时，
    // 其他线程对同一个object中所有的其他synchronized(this)同步代码块的访问将被阻塞，这说明synchronized使用的对象 监视器是一个
    public static void main(String[] args) {

        ObjectService service = new ObjectService();
        ThreadA a = new ThreadA(service);
        a.setName("a");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();
    }
}
