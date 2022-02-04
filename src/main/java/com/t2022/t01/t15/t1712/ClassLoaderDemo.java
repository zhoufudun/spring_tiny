package com.t2022.t01.t15.t1712;

public class ClassLoaderDemo {


    public static void main(String[] args) {
        System.out.println("ClassLoader Demo ClassLoader is " + ClassLoaderDemo.class.getClassLoader());
        System.out.println("The parent of ClassLoaderDemo ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLoaderDemos ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }
}
