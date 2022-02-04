package com.t2022.t01.t13.t1035;

public class Test {


    public static void main(String[] args) {
        try {
            System.out.println("hello world");
            System.exit(0);
        }catch (Exception e ){
            System.out.println("异常");
        }finally {
            System.out.println("执行finally");
        }
    }
}
