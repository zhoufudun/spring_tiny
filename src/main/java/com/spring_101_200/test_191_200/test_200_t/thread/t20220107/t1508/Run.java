package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1508;


public class Run {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P p = new P(myStack);
        P p1 = new P(myStack);
        P p2 = new P(myStack);
        P p3 = new P(myStack);




        P_Thread p_thread = new P_Thread(p);
        p_thread.start();

        P_Thread p_thread1 = new P_Thread(p1);
        p_thread1.start();

        P_Thread p_thread2 = new P_Thread(p2);
        p_thread2.start();

        P_Thread p_thread3 = new P_Thread(p3);
        p_thread3.start();



        C c = new C(myStack);
        C_Thread c_thread = new C_Thread(c);
        c_thread.start();

    }
}
