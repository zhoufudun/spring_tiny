package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1423;

public class P_Thread extends Thread {



    private P p ;

    public P_Thread(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while(true){
            p.pushSerivce();
        }
    }
}
