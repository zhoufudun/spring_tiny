package com.spring_1_100.test_11_20.test14_set_cycle_reference;

import com.alibaba.fastjson.JSON;
import com.spring_1_100.test_11_20.test11_var_name.Foo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test14 {
    // Error creating bean with name 'boss': Requested bean is currently in creation: Is there an unresolvable circular reference?
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_11_20/spring14_set_cycle_refernce.xml");
        Car car = ac.getBean(Car.class);
        System.out.println(JSON.toJSONString(car));
    }
}
