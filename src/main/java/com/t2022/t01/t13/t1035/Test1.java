package com.t2022.t01.t13.t1035;

public class Test1 {


    public static void main(String[] args) {
        try {
            System.out.println("hello world");
            int i = 1 / 0 ;
        }catch (Exception e ){
            System.out.println("异常");
            System.exit(0);
        }finally {
            System.out.println("执行finally");
        }
    }
}
