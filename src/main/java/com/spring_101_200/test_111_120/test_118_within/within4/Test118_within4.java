package com.spring_101_200.test_111_120.test_118_within.within4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test118_within4 {
    //ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring118_within/spring_118_within1.xml");


    //4.任何目标对象对应的类型持有Secure注解的类方法；必须是在目标对象上声明这个注解，在接口上声明的对它不起作用
    //@Pointcut("@within(com.spring_1_100.test_61_70.test64_2.MyAnnotation)")
    @Test
    public void within4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring118_within/spring_118_within4.xml");
        UserAmount userAmount = ac.getBean(UserAmount.class);
        userAmount.getAmount();
        System.out.println("=============================");
        StaffService staffService = ac.getBean(StaffService.class);
        staffService.getStaffName();
        System.out.println("=============================");
        staffService.getStaffInfo();
    }


}
