package com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t0130;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run2 {
    // 查看构造方法得知，创建一个Timer 就启动一个新的线程，这个新启动的线程并不是守护进程 ，就一直运行
    private static Timer timer = new Timer(true);

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
