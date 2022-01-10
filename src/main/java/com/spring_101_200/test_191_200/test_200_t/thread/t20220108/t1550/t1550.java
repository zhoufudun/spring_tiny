package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1550;

public class t1550 {


    public static ThreadLocalExt t1 = new ThreadLocalExt();

    public static void main(String[] args) {
        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
