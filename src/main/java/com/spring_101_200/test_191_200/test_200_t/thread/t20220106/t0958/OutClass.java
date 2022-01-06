package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t0958;

public class OutClass {
    static  class InnerClass1{
        public void method1(InnerClass2 class2 ){
            String threadName = Thread.currentThread().getName();
            synchronized (class2){
                System.out.println(threadName + " 进入InnerClass1 类中的method1 方法 ");
                for(int i = 0 ;i < 10 ;i ++){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(threadName + " 离开InnerClass1类中的method1 方法");
            }
        }


        public  synchronized  void method2(){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " 进入InnerClass1 类中的method2 方法");
            for(int j = 0 ;j < 10 ; j ++){
                System.out.println("j = " + j );
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " 离开InnderClass1 类中的method2 方法 ");
        }
    }

    static  class InnerClass2{

        public synchronized  void method1(){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " 进入InnderClass2 类中的method1 方法 ");
            for(int k = 0 ;k < 10 ; k ++){
                System.out.println("k = " + k);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " 离开InnerClass2类中的method1 方法 ");
        }
    }


    public static void main(String[] args) {
        final InnerClass1 in1 = new InnerClass1();
        final  InnerClass2 in2 = new InnerClass2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                in1.method1(in2);
            }
        } , "T1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                in1.method2();
            }
        },"T2");
        //
        //
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                in2.method1();
            }
        },"T3");

        t1.start();
        t2.start();
        t3.start();
    }




}
