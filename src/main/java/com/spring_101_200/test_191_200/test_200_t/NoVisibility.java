package com.spring_101_200.test_191_200.test_200_t;

public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }


    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
