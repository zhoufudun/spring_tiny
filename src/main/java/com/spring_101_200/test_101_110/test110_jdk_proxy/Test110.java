package com.spring_101_200.test_101_110.test110_jdk_proxy;


import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

public class Test110 {



    @Test
    public void test2() throws Exception {
        Person obj = (Person) new JDKMeipo().getInstance(new Customer());
        obj.findLove();

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("/Users/quyixiao/project/spring_tiny/src/main/java/com/spring_101_200/test_101_110/test110_jdk_proxy/$Proxy0.class");
        os.write(bytes);
        os.close();
    }
}
