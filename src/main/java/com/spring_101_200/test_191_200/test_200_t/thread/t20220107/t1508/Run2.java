package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1508;



public class Run2 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        P p = new P(myStack);
        P p1 = new P(myStack);
        P p2 = new P(myStack);
        P p3 = new P(myStack);

        P_Thread p_thread = new P_Thread(p);
        P_Thread p_thread1 = new P_Thread(p1);
        P_Thread p_thread2 = new P_Thread(p2);
        P_Thread p_thread3 = new P_Thread(p3);

        p_thread.start();
        p_thread1.start();
        p_thread2.start();
        p_thread3.start();


        C c = new C(myStack);
        C c1 = new C(myStack);
        C c2 = new C(myStack);
        C c3 = new C(myStack);
        C c4 = new C(myStack);


        C_Thread c_thread = new C_Thread(c);
        C_Thread c_thread1 = new C_Thread(c1);
        C_Thread c_thread2 = new C_Thread(c2);
        C_Thread c_thread3 = new C_Thread(c3);
        C_Thread c_thread4 = new C_Thread(c4);

        c_thread.start();
        c_thread1.start();
        c_thread2.start();
        c_thread3.start();
        c_thread4.start();

    }
}
