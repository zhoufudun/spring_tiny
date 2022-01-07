package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1423;

public class C_Thread extends Thread {



    private C c ;

    public C_Thread(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while(true){
            c.popSerivce();
        }
    }
}
