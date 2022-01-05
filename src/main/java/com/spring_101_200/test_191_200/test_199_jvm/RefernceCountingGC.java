package com.spring_101_200.test_191_200.test_199_jvm;


/**
 * testGC() 方法执行之后，objA和objB会不会被GC呢？
 */
public class RefernceCountingGC {

    public  Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否有回收过
     */

    private byte [ ]  bigSize = new byte[2 * _1MB];

    public static void testGC(){
        RefernceCountingGC objA = new RefernceCountingGC();
        RefernceCountingGC objB = new RefernceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        //假设在这行发生了GC，objA 和objB 是否能回收呢？
    }
}

