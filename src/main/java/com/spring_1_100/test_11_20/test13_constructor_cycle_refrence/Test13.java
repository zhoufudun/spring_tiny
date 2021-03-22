package com.spring_1_100.test_11_20.test13_constructor_cycle_refrence;

import com.spring_1_100.test_11_20.test11_var_name.Foo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test13 {
    // Error creating bean with name 'boss': Requested bean is currently in creation: Is there an unresolvable circular reference?
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_11_20/spring13_constructor_cycle_refernce.xml");


    }
}
