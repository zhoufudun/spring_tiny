package com.spring_101_200.test_101_110.test103_timetask;

import org.junit.Test;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;

public class Test103 {


    // 业务流程产生型
    // 扫描线程产生型
    @Test
    public void test1()  throws Exception{
        Timer timer = new Timer();
        TimerTask task = new SimpleTimerTask();
        timer.schedule(task, 1000l, 5000l);

        Thread.sleep(20000);
    }

    @Test
    public void test2() throws Exception{
        ExecutorExample ee = new ExecutorExample();
        ee.setExecutor(Executors.newFixedThreadPool(3));
        ee.executeTasks();
        Thread.sleep(20000);
    }


    @Test
    public void test3() throws Exception{
        ExecutorExample1 ee = new ExecutorExample1();
        ee.setExecutor(new SimpleAsyncTaskExecutor());
        ee.executeTasks();
        Thread.sleep(20000);
    }
}
