package com.spring_101_200.test_191_200.test_199_jvm;

public class Bar {





    int a = 1;
    static  int b = 2;

    public int sum(int c ){
        return a + b + c;
    }

    public static void main(String[] args) {

        String repayNo = "2021070822001418691435365533";

        if (repayNo.length() != 32 || repayNo.length() != 28) {
            System.out.println("-------------" + repayNo);
        }



        new Bar().sum(3);
    }


}
