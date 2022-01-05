package com.spring_101_200.test_191_200.test_200_t.thread.thread7;

public class MyThread extends Thread {
    private SynchronizedObject object;


    public MyThread(SynchronizedObject object) {
        super();
        this.object = object;
    }


    @Override
    public void run() {
        object.printString("b", "bb");
    }

    public static void main(String[] args) throws Exception {
        SynchronizedObject object = new SynchronizedObject();
        MyThread thread = new MyThread(object);
        thread.start();
        Thread.sleep(500l);
        thread.stop();
        System.out.println(object.getUsername() + "     " + object.getPassword());
    }
}
