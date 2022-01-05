package com.spring_101_200.test_191_200.test_199_jvm;

import com.spring_101_200.test_111_120.test_113_conversion.A;
import sun.misc.PostVMInitHook;

public class FieldResolution {

    interface Interface0 {
        int A = 0;

    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parant implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parant implements Interface2{
        //public static int A = 4;
    }

    // Reference to 'A' is ambiguous, both 'Parant.A' and 'Interface2.A' matc
    public static void main(String[] args) {
        // System.out.println(Sub.A);
    }
}
