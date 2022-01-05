package com.spring_101_200.test_191_200.test_200_t.mianshi;

import org.aspectj.weaver.bcel.UnwovenClassFileWithThirdPartyManagedBytecode;

public class Test5 {

    public static void main(String[] args) {
        short s = 1;
        //s = s + 1 ;
        s += 1;

        int a = 5;
        System.out.println("value is " + (a < 5 ? 10.9 :9 ));

    }
}
