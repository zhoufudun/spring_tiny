package com.spring_101_200.test_191_200.test_199_jvm;

import java.lang.reflect.Method;

/***
 * Javaclass执行工具
 */
public class JavaclassExecuter {


    /**
     * 将外部传过来的代表一个Java类的byte数组
     * 将输入类byte数组中代表java.lang.System的CONSTANT_Utf8_info常量修改为劫持后的HackSystem类。
     * 执行方法为该类static main(String [] args)方法，输出结果为该类向System.out/err输出的信息
     * 代表一个Java类的Byte数组
     * 执行结果
     */
    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "java/lang/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", new Class[]{String[].class});
            method.invoke(null, new String[]{null});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HackSystem.getBufferString();
    }
}
