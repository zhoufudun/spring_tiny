package com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t1103;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run {


    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行的时间为 ：" + new Date());
        }
    }

    // 该方法的作用是执行schedule(TimeTask task ,long delay ,long period ) 方法当前的时间为参考时间 ，在此时间基础 上延迟指定的
    // 毫秒数
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        System.out.println("当前时间为" + new Date().toLocaleString());
        timer.schedule(myTask, 3000, 5000);
    }
}
