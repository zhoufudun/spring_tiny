package com.t2022.t01.design.singleton;

import java.lang.reflect.Constructor;

public class InnerClassSingleton {

    private static class InnerClassHolder {
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    private InnerClassSingleton() {
        if(InnerClassHolder.instance !=null){
            throw  new RuntimeException("单例不允许多个实例");
        }
    }

    public static InnerClassSingleton getInstance() {
        return InnerClassHolder.instance;
    }


    public static void main(String[] args)  throws Exception{
        Constructor<InnerClassSingleton> innerClassSingletonConstructor = InnerClassSingleton.class.getDeclaredConstructor();
        innerClassSingletonConstructor.setAccessible(true);
        InnerClassSingleton innerClassSingleton = innerClassSingletonConstructor.newInstance();
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(innerClassSingleton == instance);
    }
}
