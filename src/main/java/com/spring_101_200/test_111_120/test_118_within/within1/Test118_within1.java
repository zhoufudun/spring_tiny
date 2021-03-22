package com.spring_101_200.test_111_120.test_118_within.within1;

import com.spring_1_100.test_61_70.test64_2.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test118_within1 {
//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring_117_excution/spring_117_excution13.xml");


    // 1.com..test64_2包及子包下的任何方法执行
    // @Pointcut("within(com..test64_2..*)")
    @Test
    public void within1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring118_within/spring_118_within1.xml");
        Car car = ac.getBean(Car.class);
        car.driver();
    }

}
