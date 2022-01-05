package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_0959;

public class MyObject {
    private String username = "1";
    private String password = "11";

    public void setValue(String u, String p) {
        this.username = u;
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("停止a线程！");
            Thread.currentThread().suspend();
        }
        this.password = p;
    }

    public void printUserNamePassword() {
        System.out.println(username + " " + password);
    }


    public static void main(String[] args) throws Exception {
        final MyObject myObject = new MyObject();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                myObject.setValue("a", "aa");
            }
        };
        thread1.setName("a");
        thread1.start();

        Thread.sleep(500);


        Thread thread2 = new Thread() {
            @Override
            public void run() {
                myObject.printUserNamePassword();
            }
        };
        thread2.start();
    }
}
