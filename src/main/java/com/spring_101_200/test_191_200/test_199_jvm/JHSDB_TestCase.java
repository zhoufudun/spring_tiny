package com.spring_101_200.test_191_200.test_199_jvm;

public class JHSDB_TestCase {
    static  class Test{
        static  ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo(){
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); //这里设置一个断点
        }
    }



    private static class ObjectHolder {

    }


    public static void main(String[] args) {

    }
}
