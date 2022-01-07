package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1423;

public class Run {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P p = new P(myStack);
        C c = new C(myStack);
        C c1 = new C(myStack);
        C c2 = new C(myStack);
        C c3 = new C(myStack);
        C c4 = new C(myStack);

        P_Thread p_thread = new P_Thread(p);
        p_thread.start();

        C_Thread c_thread = new C_Thread(c);
        c_thread.start();

        C_Thread c_thread1 = new C_Thread(c1);
        c_thread1.start();
        C_Thread c_thread2 = new C_Thread(c2);
        c_thread2.start();
        C_Thread c_thread3 = new C_Thread(c3);
        c_thread3.start();
        C_Thread c_thread4 = new C_Thread(c4);
        c_thread4.start();
    }
}
