package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1254;

public class ThreadB extends Thread {

    private MyList list;
    public ThreadB(MyList list ) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while(true){
                if(list.size() == 5 ){
                    System.out.println("==5 了，线程b要退出了！");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
