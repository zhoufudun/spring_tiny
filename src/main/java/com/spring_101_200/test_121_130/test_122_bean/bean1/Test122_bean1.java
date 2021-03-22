package com.spring_101_200.test_121_130.test_122_bean.bean1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test122_bean1 {
//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring_117_excution/spring_117_excution13.xml");


    // f) bean
    // 1.匹配所有以Service命名（id或name）结尾的Bean
    // @Pointcut(value="bean(*Service)")
    @Test
    public void target1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_121_130/spring122_bean/spring_122_bean1.xml");
        Car car = ac.getBean(Car.class);
        car.driver();

        System.out.println("===========================");
        MyService myService = ac.getBean(MyService.class);
        myService.service();
    }


}
