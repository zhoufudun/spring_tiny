package com.spring_101_200.test_111_120.test_113_conversion;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;

public class TestTypeDescriptor {

    @Test
    public void test1(){
        Integer a = 1;
        System.out.println(a.getClass());


        System.out.println("-----------------");
        TypeDescriptor typeDescriptor = TypeDescriptor.forObject(a);

        System.out.println(typeDescriptor.getName());
        System.out.println(typeDescriptor.getObjectType());
        System.out.println(typeDescriptor.getType());
        System.out.println(typeDescriptor.getAnnotations());
        System.out.println(typeDescriptor.getSource());

    }
}
