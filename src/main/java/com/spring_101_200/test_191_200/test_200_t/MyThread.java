package com.spring_101_200.test_191_200.test_200_t;

public class MyThread extends Thread {


    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();           //如果多次调用 start()方法 ，则Exception in thread "main" java.lang.IllegalThreadStateException
        //myThread.start();
        //myThread.start();
        //myThread.start();
        System.out.println("运行结束 ");
    }
}
