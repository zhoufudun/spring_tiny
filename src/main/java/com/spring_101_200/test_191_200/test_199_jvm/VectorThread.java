package com.spring_101_200.test_191_200.test_199_jvm;

import java.util.Vector;

public class VectorThread {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while(true){
            for(int i =  0;i < 10;i ++){
                vector.add(i);
            }
            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0 ;i < vector.size() ;i ++){
                        vector.remove(i);
                    }
                }
            });
            Thread printThead = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0 ;i < vector.size() ;i ++){
                        System.out.println(vector.get(i));
                    }
                }
            });

            removeThread.start();
            printThead.start();
            //不要同时产生过多的线程，不然会导致操作系统假死
            while (Thread.activeCount()> 20 );


        }
    }
}
