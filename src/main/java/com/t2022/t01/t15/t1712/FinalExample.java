package com.t2022.t01.t15.t1712;

public class FinalExample {

    private int j;

    private static FinalExample obj;


    public FinalExample() {
        this.j = 2;
    }

    public static void write() { //线程A先执行write
        obj = new FinalExample();
    }

    public static void read() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (obj != null) {
            int a = obj.j;
            System.out.println("a=" + a); // b的值是 ？
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                write();
            }
        });


        for(int i = 0 ;i < 1000 ;i ++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    read();
                }
            }).start();
        }

        t1.start();

    }


}
