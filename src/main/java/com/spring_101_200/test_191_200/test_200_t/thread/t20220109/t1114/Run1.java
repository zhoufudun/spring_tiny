package com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t1114;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run1 {



    private static Timer timer = new Timer();

    private static int runCount = 0 ;

    // 方法schedule和方法scheduleAtFixedRate都会按顺序执行，所以还要考虑非线程安全的情况
    // 方法schedule和scheduleAtFiexedRate 的主要区别只在于不延迟的是情况
    // 使用schedule方法，如果执行任务的时间没有被延迟，那么下一次任务的执行时间参考是上一次任务的开始时间来计算
    // 使用scheduleAtFiexdRate方法：如果执行任务的时间没有被延时，那么下一次任务的执行时间参考的是上一次的任务的结束时间来计算
    // 延时的情况则没有什么区别，也就是使用schedule或scheduleAtFiexdRate方法都是如果执行任务的时间被延时，那么下一次任务的的执行时间
    // 就是上一次任务的执行的结束时间来计算
    static public class MyTask1 extends TimerTask{
        @Override
        public void run() {
            try {
                System.out.println(" 1 begin 运行了 时间为 " + new Date());
                Thread.sleep(1000);
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

    // 控制台的打印结果证明，在不延时的情况下，如果执行任务的时间没有被延时，则下一次任务的时间时间是上一次任务的开始时间加上delay时间
    public static void main(String[] args)  throws Exception{
        MyTask1 myTask1 =new MyTask1();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = simpleDateFormat.parse("2014-10-12 15:11:00");

        System.out.println("字符串的1的时间为" +  date1.toLocaleString() + " , 当前时间为：" + new Date().toLocaleString());

        timer.schedule(myTask1, date1, 3000);
    }
}
