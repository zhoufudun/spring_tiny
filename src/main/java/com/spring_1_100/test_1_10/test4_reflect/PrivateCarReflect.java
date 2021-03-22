package com.spring_1_100.test_1_10.test4_reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateCarReflect {

    //
    public static void main(String[] args)  throws Exception{

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.spring_1_100.test_1_10.test4_reflect.PrivateCar");

        PrivateCar pcar =(PrivateCar) clazz.newInstance();

        Field colorFld = clazz.getDeclaredField("color");
        // 在访问 private ,protected 成员变量和方法时必需通过 setAccessible(boolean access) 方法取消相应的 java
        // 类型检查，否则将抛出 IllegalAccessException , 如果 JVM 的安全†宣刘轩了相应的安全机制，调用该方法将抛出 SecurityException
        colorFld.setAccessible(true);
        colorFld.set(pcar,"红色");

        Method method = clazz.getDeclaredMethod("drive",(Class[])null);

        method.setAccessible(true);
        method.invoke(pcar,(Object[])null);


    }
}
