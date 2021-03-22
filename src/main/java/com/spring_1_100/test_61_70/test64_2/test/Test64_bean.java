package com.spring_1_100.test_61_70.test64_2.test;

import com.spring_1_100.test_61_70.test64_2.Car;
import com.spring_1_100.test_61_70.test64_2.MyService;
import com.spring_1_100.test_61_70.test64_2.UserService;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test64_bean {




    // f) bean
    // 1.匹配所有以Service命名（id或name）结尾的Bean
    // @Pointcut(value="bean(*Service)")
    @Test
    public void target1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        Car car = ac.getBean(Car.class);
        car.driver();

        System.out.println("===========================");
        MyService myService = ac.getBean(MyService.class);
        myService.service();
    }

}
