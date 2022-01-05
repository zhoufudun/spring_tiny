package com.spring_101_200.test_191_200.test_199_jvm;

public class DynamicDispatch {


    static abstract class Human{
        protected abstract void sayHello();
    }


    static class Man extends  Human{
        @Override
        protected void sayHello() {
            System.out.println("Man say Hello");
        }

    }

    static class Woman extends  Human{
        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }


    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();


        man.sayHello();
        woman.sayHello();
        man = new Woman() ;
        man.sayHello();

    }
}
