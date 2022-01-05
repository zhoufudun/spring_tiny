package com.spring_101_200.test_191_200.test_199_jvm;

import org.aspectj.org.eclipse.jdt.internal.core.util.PublicScanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreateBusyThreadTest {

    public static void createBusyThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true);
            }
        },"testBusyThead");
        thread.start();
    }

    public  static void createLockThread(final  Object lock){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"testLockThead");
        thread.start();
    }
    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object obj = new Object();
        createLockThread(obj);
    }
}
