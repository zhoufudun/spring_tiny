package com.spring_101_200.test_101_110.test103_timetask;

import org.springframework.core.task.TaskExecutor;

import java.util.concurrent.Executor;

public class ExecutorExample1 {


    private TaskExecutor executor;


    public void executeTasks() {
        for (int i = 0; i < 6; i++) {
            executor.execute(new SimpleTask("task" + i ));
        }
    }

    public TaskExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(TaskExecutor executor) {
        this.executor = executor;
    }
}


