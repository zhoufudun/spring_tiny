package com.spring_1_100.test_31_40.test35_resource_inject;

public class MyTest35_2 {
    String str = "Welcome";
    private int x = 5;
    private static Integer in = 10;

    public static void main(String[] args) {
        MyTest35_2 myTest35_1 = new MyTest35_2();
        myTest35_1.setX(8);
        in = 20;
    }

    public void setX(int x) {
        this.x = x;
    }


    public final   synchronized   static  void setXXX(int x) {

    }
}
