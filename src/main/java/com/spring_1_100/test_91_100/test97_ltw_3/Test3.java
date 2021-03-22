package com.spring_1_100.test_91_100.test97_ltw_3;

import org.aspectj.apache.bcel.classfile.Attribute;
import org.aspectj.apache.bcel.classfile.ClassParser;
import org.aspectj.apache.bcel.classfile.JavaClass;
import org.aspectj.apache.bcel.classfile.Method;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test3 {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/quyixiao/git/spring_tiny/target/classes/com/spring_1_100/test_91_100/test97_ltw_3/MyAnnotationBeanConfigurerAspect.class");
        InputStream inputStream = new FileInputStream(file);
        ClassParser parser = new ClassParser(inputStream, file.getPath());
        JavaClass jc = parser.parse();
        Method[] methods  = jc.getMethods();
        for(Method method:methods){
            Attribute[] attributes = method.getAttributes();
            for(Attribute attribute:attributes){
                System.out.println(method.getName() + "=========="+attribute.getName());
            }
        }
    }
}
