package com.spring_101_200.test_111_120.test_111_cglib_proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;

public class Test111 {


    @Test
    public void test1() throws Exception{
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"/Users/quyixiao/project/spring_tiny/src/main/java/com/spring_101_200/test_111_120/test_111_cglib_proxy");
        Customer obj = (Customer) new CglibMeipo().getInstance(Customer.class);
        obj.findLove();
    }



    @Test
    public void test2() throws Exception{
        Customer obj = (Customer) new SpringCglib().getInstance(Customer.class,2);
        obj.findLove();
    }

}
