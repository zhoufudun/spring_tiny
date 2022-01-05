package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1139;

// 可见，方法setValue和getValue()被依次执行，通过这个安全不仅要知道脏读是通过synchronized关键字的解决，还要知道如下内容
// 当A线程调用 ，anyObject对象加入synchronized关键字的X方法时，A 线程就获取了X方法锁，更准确地讲，是获取了对象的锁，所以其他线程必须等
// A 线程执行完毕才可以调用 X 方法，但是B 线程随意调用其他非synchronized同步方法
// 当A 线程调用anyObject对象加入synchronized关键字的X方法时，A线程就获得了X方法所在的对象的锁，所以其他线程就必等A 线程执行完毕才可以调用
// X方法，而B线程如果调用声明了synchronized关键字的非X方法时，必须等A线程将X方法执行完，也就是释放对象锁后才可以调用，这时A线程已经执行了一个
// 完整的任务，也就是说username和password这两个实例变量已经同时被赋值，不存在脏读的基本环境
public class ThreadA extends Thread {


    private PublicVar publicKey;


    public ThreadA(PublicVar publicKey) {
        super();
        this.publicKey = publicKey;
    }

    @Override
    public void run() {
        super.run();
        publicKey.setValue("B", "BB");
    }


    public static void main(String[] args) throws Exception {
        PublicVar publicVar = new PublicVar();
        ThreadA threadA = new ThreadA(publicVar);
        threadA.start();
        Thread.sleep(200); //打印结果值受点缀值大小的影响
        publicVar.getValue();

    }
}
