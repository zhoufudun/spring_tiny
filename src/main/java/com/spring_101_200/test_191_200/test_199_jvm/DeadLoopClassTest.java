package com.spring_101_200.test_191_200.test_199_jvm;

public class DeadLoopClassTest {


    static class DeadLoopClass {
         static { //如果不加上这个if语句，编译器将提示"Initializer must be able to complete normally"
             //并且拒绝编译
             if(true){
                 System.out.println(Thread.currentThread() + "init DeadLoopClass ");
                 while (true){

                 }
             }
         }
    }


    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start ");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " run over ");
            }
        };
        Thread thread1 = new Thread(script);
        Thread thread2  = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
