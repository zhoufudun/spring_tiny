package com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t1114;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run2 {



    private static Timer timer = new Timer();

    private static int runCount = 0 ;


    static public class MyTask1 extends TimerTask{
        @Override
        public void run() {
            try {
                System.out.println(" 1 begin 运行了 时间为 " + new Date());
                Thread.sleep(2000);
                System.out.println(" 1 end 运行了，时间为 " + new Date());
                runCount ++ ;
                if(runCount == 5 ){
                    timer.cancel();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 从控制台打印结果来看，如果执行任务的时间被延时，那么下一次任务的执行时间以上一次任务的结束时间为参考来计算
    public static void main(String[] args)  throws Exception{
        MyTask1 myTask1 =new MyTask1();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = simpleDateFormat.parse("2014-10-12 15:11:00");

        System.out.println("字符串的1的时间为" +  date1.toLocaleString() + " , 当前时间为：" + new Date().toLocaleString());

        timer.scheduleAtFixedRate(myTask1, date1, 5000);
    }
}
