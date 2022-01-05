package com.spring_101_200.test_191_200.test_199_jvm;

import java.lang.invoke.MethodType;

public class MethodHandle {


    static class ClassA{
        public void println(String s ){
            System.out.println("s");
        }
    }

    public static void main(String[] args)  throws Throwable{
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out:new ClassA();
        //无论是obj最终是哪个实现类，下面的这句都能正常调用 print方法
        //getPrintlnMH(obj).invokeExact("icyfenix");
    }

    private static MethodHandle getPrintlnMH(Object reveiver) throws Throwable{
        //Method Type 代表方法类型，包含了方法的返回值 （methodType）的第一个参数和具体的参数）和
        // 具体参数（methodType()第二个及以后的参数）
        MethodType mt = MethodType.methodType(void.class,String.class);
        // lookup()方法来自于MethodHandles.lookup.这句的作用是在指定类中查找符合给定的方法名称
        // 名称 ，方法类型，并且符合调用权限的方法句柄
        // 因为这里调用的是一个虚方法，按照Java语言的规则，方法第一个参数隐式的，代表该方法的接收者
        // 也即this指向对象，这个参数以前是放在参数列表中进行传递，现在提供了bindTo()方法来完成这件事情
        //return lookup().findVirtual(reveiver.getClass(),"println",mt).bindTo(re)
        return null;
    }

}
