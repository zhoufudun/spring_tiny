package com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t0138;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run {
    private static Timer timer = new Timer();

    static public class MyTask1 extends TimerTask {

        @Override
        public void run() {
            System.out.println("运行了时间为" + new Date());
        }

    }


    static public class MyTask2 extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了时间为" + new Date());
        }
    }

    // TimerTask是以队列的方式一个一个的被顺序执行的，所以执行时间上可能和预期的时间不一致辞，因此前面的任务可能消耗时间比较长
    // 则后面的任务运行的时间也会被延迟，
    public static void main(String[] args) throws Exception {

        MyTask1 task1 = new MyTask1();
        MyTask2 task2 = new MyTask2();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = simpleDateFormat.parse("2022-01-09 01:44:00");
        Date date2 = simpleDateFormat.parse("2022-01-09 01:45:00");

        System.out.println("字符串1时间 " + date1.toLocaleString() + " 当前时间 ：" + new Date().toLocaleString());
        System.out.println("字符串1时间 " + date2.toLocaleString() + " 当前时间 ：" + new Date().toLocaleString());
        timer.schedule(task1, date1);
        timer.schedule(task2, date2);

    }

}
