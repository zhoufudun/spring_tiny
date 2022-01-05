package com.spring_101_200.test_191_200.test_199_jvm;

public class TestAllocation {

    public static final int _1MB = 1024 * 1024 ;

    public static void main(String[] args) {
         byte [ ] allocation1 ,allocation2,allocation3 ,allocation4  ;
         allocation1 = new byte[2 * _1MB];
         allocation3 = new byte[2 * _1MB];
         allocation3 = new byte[2 * _1MB];
         allocation4 = new byte[2 * _1MB];


    }
}
