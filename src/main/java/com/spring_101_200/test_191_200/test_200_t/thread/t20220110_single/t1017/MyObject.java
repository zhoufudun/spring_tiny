package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1017;

public class MyObject {

    private static MyObject instance = null;

    private MyObject() {

    }

    static {
        instance = new MyObject();
    }

    public static MyObject getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(MyObject.getInstance().hashCode());
                }
            }).start();
        }
    }
}
