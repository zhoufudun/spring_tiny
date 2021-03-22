package com.spring_101_200.test_101_110.test103_timetask;

import java.util.Date;
import java.util.TimerTask;

public class SimpleTimerTask extends TimerTask {
    private int count = 0;
    @Override
    public void run() {
        System.out.println("execute task");
        Date exeTime = (new Date(scheduledExecutionTime())); // 获取本次安排执行时间
        System.out.println("本次任务安排执行时间点为 ：" + exeTime);
        if( ++ count > 10 ){
            cancel();
        }

    }
}
