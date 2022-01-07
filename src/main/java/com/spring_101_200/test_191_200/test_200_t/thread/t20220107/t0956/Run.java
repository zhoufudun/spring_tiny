package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t0956;

public class Run {


    // 再现这样的异常的原因是因为有两个实现删除remove()操作的线程，它们在Thread.sleep(1000) 之前都执行了wait()方法，呈等待状态
    // 当操作的线程在1秒之后被运行时，通知了所有呈wait等待状态的减操作的线程，那么第一个实现减接任的线程能正确的删除list中的索引为0
    // 的数据，但第二个实现减操作的线程则出现了索引溢出的异常，因为list中仅仅添加了一个数据，也只能删除一个数据，所以没有第二个数据可供
    // 删除 ，如何解决这样的问题呢？

    public static void main(String[] args) throws Exception {
        String lock = new String("");
        Add add = new Add(lock);
        Subtract sub = new Subtract(lock);


        ThreadSub threadSub = new ThreadSub(sub);
        threadSub.setName("threadSubNameA");
        threadSub.start();


        ThreadSub threadSub2 = new ThreadSub(sub);
        threadSub2.setName("threadSubNameB");
        threadSub2.start();

        Thread.sleep(1000);

        ThreadAdd threadAdd = new ThreadAdd(add);
        threadAdd.setName("addThread");
        threadAdd.start();


    }


}
