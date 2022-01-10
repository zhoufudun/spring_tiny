package com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t0159;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run2 {

    static public class MyTaskA extends TimerTask {
        @Override
        public void run() {
            System.out.println(" A 运行的时间 为" + new Date());
            this.cancel();
        }
    }



    static public class MyTaskB extends TimerTask {
        @Override
        public void run() {
            System.out.println("B 运行了时间 ："  + new Date());
        }
    }



    //如果计划时间早于当前时间，则立即执行task任务
    // TimerTask类中的cancel() 方法是将自身的任务队列中被移除，其他任务不受影响
    // TimeTask类中的cancel()方法清除自身的不同，Timer类中的cancel()方法的作用是将任务队列中全部的任务清空
    public static void main(String[] args) throws Exception {
        MyTaskA taskA = new MyTaskA();
        MyTaskB taskB = new MyTaskB();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = simpleDateFormat.parse("2022-01-09 01:54:00");
        System.out.println("字符串1时间 " + date2.toLocaleString() + " 当前时间 ：" + new Date().toLocaleString());
        Timer timer = new Timer();
        timer.schedule(taskA, date2, 4000);
        timer.schedule(taskB, date2, 4000);

    }
}
