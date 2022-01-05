package com.spring_101_200.test_191_200.test_199_jvm;

public class IncTest {


    public static int inc(){
        int x ;
        try {
            x = 1;
            return x ;
        } catch (Exception e) {
            x = 2;
            return x ;
        }finally {
            x = 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(     inc());
    }
}
