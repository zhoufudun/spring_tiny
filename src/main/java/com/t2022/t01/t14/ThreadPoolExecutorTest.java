package com.t2022.t01.t14;

import com.spring_1_100.test_41_50.test41.User;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws Exception{
        Object a = new User();
        Callable<Object> b = Executors.callable(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试 ");
            }
        }, a);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5, // 核心线程数为5 ,
                10, // 最大线程数
                1l, // 等待时间为l
                TimeUnit.SECONDS, // 等待时间单位为TimeUnit.SECONDS
                new ArrayBlockingQueue<>(100), // 任务队列为ArrayBlockingQueue ，并且容量为100 ；
                new ThreadPoolExecutor.CallerRunsPolicy()       // 饱和策略为CallerRunsPolicy
        );
        Future future = executor.submit(b);
        Object c = future.get();

        System.out.println(c);

    }
}
