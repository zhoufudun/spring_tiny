package com.spring_101_200.test_101_110.test103_timetask;

import java.util.concurrent.Executor;

public class ExecutorExample {


    private Executor executor;


    public void executeTasks() {
        for (int i = 0; i < 6; i++) {
            executor.execute(new SimpleTask("task" + i ));
        }
    }


    public Executor getExecutor() {

        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }


}


