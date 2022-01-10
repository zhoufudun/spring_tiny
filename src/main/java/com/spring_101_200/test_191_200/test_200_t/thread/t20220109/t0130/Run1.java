package com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t0130;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run1 {

    private static Timer timer = new Timer();

    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了时间 ： " + new Date());
        }
    }

    public static void main(String[] args) throws Exception {
        MyTask task = new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2022-01-09 01:35:00";
        Date dateRef = sdf.parse(dateString);
        System.out.println("字符串的时间为：" + dateRef.toLocaleString() + " 当前时间 ：" + new Date().toLocaleString());
        timer.schedule(task, dateRef);
    }
}
