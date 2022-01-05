package com.spring_101_200.test_191_200.test_200_t.mianshi;

public class Test3 {
    public static void main(String[] args) {

        int i= 0 ;
        i = i ++ + ++i;
        System.out.println(i);      //2

        int j  = 0;
        j = ++j + j ++ + j ++ + j ++; // 1 + 1 + 2 + 3 = 7
        System.out.println(j);      //

        //Short  myshort = 99S;
        float  z = 1.0f;
        int c = "abc".length();
        //char x = 17c;

        char cc = '1';
        int xx = Character.getNumericValue(cc);
        System.out.println(xx);



    }

}
