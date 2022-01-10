package com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t0153;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run {

    // 从运行结果上来年地，时间早于当前时间
    static public class Mytask extends TimerTask {
        @Override
        public void run() {
            System.out.println(" 运行了时间为：" + new Date());
        }
    }

    public static void main(String[] args) throws Exception {
        Mytask mytask = new Mytask();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = simpleDateFormat.parse("2022-01-09 01:54:00");
        System.out.println("字符串1时间 " + date2.toLocaleString() + " 当前时间 ：" + new Date().toLocaleString());
        Timer timer = new Timer();
        timer.schedule(mytask, date2, 4000);

    }

}
