package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1420;

public class RunTestXXX {

    public static void main(String[] args) {
        // 方法activeGroupCount() 取得当前线程组对象中的子线程组的数量
        // 方法enumerate()的作用是将线程组带上的子线程组以复制的形式
        // 拷贝到ThreadGroup[] 数组对象中
        System.out.println(" A 处线程：" + Thread.currentThread().getName() + " 所属的线程组名为：" +
                Thread.currentThread().getThreadGroup().getName() + " " + " 中有线程组的数量 ：" +
                Thread.currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup group = new ThreadGroup("新的组");// 自动加到main组中
        System.out.println("B 处理线程：" + Thread.currentThread().getThreadGroup()
                + " 所属的线程名为：" + Thread.currentThread().getThreadGroup().activeGroupCount()
                + " 中有线程组数量： " + Thread.currentThread().getThreadGroup().activeGroupCount()
        );

        // 本实例要证明的是，在实例化一个ThreadGroup线程组x时，如果不指定所属组的线程组，则x线程组自动照到当前线程对象所属的线程组中
        // ，也就隐式地在一个线程组带上添加一个子线程组，所以在控制台中打印的线程组数量值由0变成了1
        ThreadGroup[] threadGroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadGroup);
        for (int i = 0; i < threadGroup.length; i++) {
            System.out.println("第一个线程组名称为：" + threadGroup[i].getName());
        }
    }
}
