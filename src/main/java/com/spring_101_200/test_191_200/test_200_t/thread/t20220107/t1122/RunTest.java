package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1122;

public class RunTest {


    // 本示例是1个生产者和1个消费者进行数据交互，在控制台中打印的日志get和set的交替运行
    // 但如果在此实验的基础上，设计出多个生产者和多个消费者，那运行时极有可能出现假死的情况，也就是所有的线程都wait状态
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C r = new C(lock);

        ThreadP threadP = new ThreadP(p);
        ThreadC threadC = new ThreadC(r);
        threadP.start();
        threadC.start();
    }
}
