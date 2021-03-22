package com.spring_101_200.test_111_120.test_118_within.within3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test118_within3 {
    //ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring118_within/spring_118_within1.xml");


    //3.持有cn.javass..Secure注解的任何类型的任何方法必须是在目标对象上声明这个注解，在接口上声明的对它不起作用
    //@Pointcut("within(@com.spring_1_100..MyAnnotation *)")
    @Test
    public void within3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring118_within/spring_118_within3.xml");
        UserAmount userAmount = ac.getBean(UserAmount.class);
        userAmount.getAmount();
        System.out.println("=============================");
        StaffService staffService = ac.getBean(StaffService.class);
        staffService.getStaffName();
        System.out.println("=============================");
        staffService.getStaffInfo();
    }

}
