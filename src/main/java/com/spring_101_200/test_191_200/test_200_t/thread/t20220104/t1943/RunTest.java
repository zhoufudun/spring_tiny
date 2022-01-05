package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1943;

public class RunTest {

    // 从运行结果上来看，并没有什么特别的地方，都是同步效果，和将synchronized关键字回到非static方法上使用的效果是一样的，其实还有本质
    // 上是不同的，synchronized关键字回到static 静态方法上是给Class类上锁，而synchronized关键字回到非static静态方法上是给对象上锁
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB();
        b.setName("B");
        b.start();
    }
}
