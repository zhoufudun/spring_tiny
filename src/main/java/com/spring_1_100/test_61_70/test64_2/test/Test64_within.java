package com.spring_1_100.test_61_70.test64_2.test;

import com.spring_1_100.test_61_70.test64_2.Car;
import com.spring_1_100.test_61_70.test64_2.StaffService;
import com.spring_1_100.test_61_70.test64_2.UserAmount;
import com.spring_1_100.test_61_70.test64_2.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test64_within {

    // 1.com..test64_2包及子包下的任何方法执行
    // @Pointcut("within(com..test64_2..*)")
    @Test
    public void within1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        Car car = ac.getBean(Car.class);
        car.driver();
    }

    // 2.com..test64_2 包或所有子包下 类型及子类型的任何方法
    //@Pointcut("within(com..test64_2..UserService+)")
    @Test
    public void within2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        Car car = ac.getBean(Car.class);
        car.driver();
        System.out.println("=============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUser();
    }

    //3.持有cn.javass..Secure注解的任何类型的任何方法必须是在目标对象上声明这个注解，在接口上声明的对它不起作用
    //@Pointcut("within(@com.spring_1_100..MyAnnotation *)")
    @Test
    public void within3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        UserAmount userAmount = ac.getBean(UserAmount.class);
        userAmount.getAmount();
        System.out.println("=============================");
        StaffService staffService = ac.getBean(StaffService.class);
        staffService.getStaffName();
        System.out.println("=============================");
        staffService.getStaffInfo();
    }



    //4.任何目标对象对应的类型持有Secure注解的类方法；必须是在目标对象上声明这个注解，在接口上声明的对它不起作用
    //@Pointcut("@within(com.spring_1_100.test_61_70.test64_2.MyAnnotation)")
    @Test
    public void within4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        UserAmount userAmount = ac.getBean(UserAmount.class);
        userAmount.getAmount();
        System.out.println("=============================");
        StaffService staffService = ac.getBean(StaffService.class);
        staffService.getStaffName();
        System.out.println("=============================");
        staffService.getStaffInfo();
    }

}
