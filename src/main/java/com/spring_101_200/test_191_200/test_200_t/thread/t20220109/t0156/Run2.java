package com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t0156;

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
            Utils.sleep(5000);
            System.out.println(" A 运行结果时间为 " + new Date());
        }
    }
    //如果计划时间早于当前时间，则立即执行task任务
    public static void main(String[] args) throws Exception {
        MyTaskA taskA = new MyTaskA();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = simpleDateFormat.parse("2022-01-09 01:54:00");
        System.out.println("字符串1时间 " + date2.toLocaleString() + " 当前时间 ：" + new Date().toLocaleString());
        Timer timer = new Timer();
        timer.schedule(taskA, date2, 4000);
    }
}
