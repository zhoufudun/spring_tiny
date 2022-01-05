package com.spring_101_200.test_191_200.test_199_jvm;




public class SubTest {


    static class  Parent{
        public  static  int A = 1;
        static {
            A = 2;
        }
    }

    static class  Sub extends Parent {
        public static  int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }

}
