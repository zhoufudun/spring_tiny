package com.t2022.t01.t15.t1712;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {


    private static final int CORE_POOL_SIZE = 5;

    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1l;

    // 使用阿里巴巴推荐的创建线程池的方式
    // 通过ThreadPoolExecutor构造函数自定义参数创建
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE, // 核心线程数为5
                MAX_POOL_SIZE, // 最大线程数
                KEEP_ALIVE_TIME, // 等待时间为l
                TimeUnit.SECONDS, // 等待时间单位为TimeUnit.SECONDS
                new ArrayBlockingQueue<>(QUEUE_CAPACITY), // 任务队列为ArrayBlockingQueue ，并且容量为100 ；
                new ThreadPoolExecutor.CallerRunsPolicy()       // 饱和策略为CallerRunsPolicy
        );

        for (int i = 0; i < 10; i++) {
            // 创建Worker Thread 对象（WorkerThread类实现了Runnable接口）
            Runnable worker = new MyRunnable("" + i);
            // 执行Runnable
            executor.execute(worker);
        }
        // 终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("Finished all threads ");
    }

}
