package com.spring_101_200.test_191_200.test_199_jvm;


import java.lang.invoke.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.ConstantCallSite;


public class InvokeDynamicTest {


    public static void main(String[] args) {

    }

    public static void testMethod(String s){
        System.out.println("Hello String :" + s );
    }

    public static CallSite BootstrapMethdod(MethodHandles.Lookup lookup, String name , MethodType mt ) throws Exception{
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class,name,mt));
    }

    private static MethodType MT_BootstrapMethod() throws IllegalArgumentException, TypeNotPresentException{
        return MethodType.fromMethodDescriptorString("(Ljava/lang/invoke/MethodHandles$Lookup;)",ClassLoader.getSystemClassLoader());
    }

    private static MethodHandle MH_BootstrapMethod() throws Throwable{
        //return lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod",MT_BootstrapMethod());
        return null;
    }

    private static MethodHandle INDY_BootstrapMethod() throws Throwable{
        //CallSite cs = (CallSite)MH_BootstrapMethod().invokeWithArguments(lookup(),"testMethod",
          //      MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V",null));
        //return cs.dynamicInvoker();
        return null;
    }

}



