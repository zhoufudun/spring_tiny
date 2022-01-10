package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1006;

public class MyObject {
    // 内部类方式
    private static class MyObjectHandler {
        private static MyObject myObject = new MyObject();

    }

    private MyObject() {

    }

    public static MyObject getInstance() {
        return MyObjectHandler.myObject;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(MyObject.getInstance().hashCode());
                }
            }).start();
        }
    }
}
