package com.t2022.t01.t13.t1021;

public class Test {


    public static int test() {
        int result = 0;
        try {
            //... 如果抛异常和未抛出异常 ，test()方法分别返回的值是多少 ？
            return result;
        } catch (Exception e) {
            result = 1;
        } finally {
            result = 2;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(test());
    }
}
