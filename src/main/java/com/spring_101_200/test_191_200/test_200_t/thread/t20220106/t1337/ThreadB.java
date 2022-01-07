package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1337;

public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }


    @Override
    public void run() {
        try {
           synchronized (lock){
               for (int i = 0; i < 10; i++) {
                   MyList.add();
                   if (MyList.size() == 5) {
                       lock.notify();
                       System.out.println("已经发出通知了");
                   }
                   System.out.println("添加了" + (i + 1 ) + "元素 ");
                   Thread.sleep(1000);
               }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
