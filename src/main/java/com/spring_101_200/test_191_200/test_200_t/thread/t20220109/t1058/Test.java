package com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t1058;

import com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t0153.Run;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test {


    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行时间为" + new Date());
        }
    }

    // 任务task 被延迟7秒后执行的，结果如下图所示
    public static void main(String[] args) {

        Run.Mytask mytask = new Run.Mytask()  ;
        Timer timer = new Timer();
        System.out.println("当前时间 为" + new Date().toString());
        timer.schedule(mytask,7000);
    }
}
