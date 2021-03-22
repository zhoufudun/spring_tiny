package com.spring_101_200.test_111_120.test_113_conversion;

import org.junit.Test;
import org.springframework.core.convert.TypeDescriptor;

public class TypeDescriptorTestxxx {

    @Test
    public void test1(){
        int a = 1 ;
        TypeDescriptor typeDescriptor = TypeDescriptor.forObject(a);

    }
}
