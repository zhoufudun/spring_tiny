package com.spring_101_200.test_191_200.test_199_jvm;

public class TestXX {

    static {
        i = 0 ; // 给变量复制可以正常编译通过
        //System.out.println(i); // 这句编译器会提示"非法向前引用 " , Illegal forward reference
    }

    static int i ;

    public static void main(String[] args) {


        int a = 6 + 8 + 6 + 6 + 6 + 6 + 6 + 8 + 8 + 8 + 8 + 4 + 4 + 4 + 8 + 4 + 4 + 8 + 8 + 8 ;
        int b = 128 /8 ;
        System.out.println(b);
        System.out.println(a );
    }
}
