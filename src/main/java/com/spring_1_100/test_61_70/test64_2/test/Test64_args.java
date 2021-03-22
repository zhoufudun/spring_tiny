package com.spring_1_100.test_61_70.test64_2.test;

import com.spring_1_100.test_61_70.test64_2.Car;
import com.spring_1_100.test_61_70.test64_2.Model;
import com.spring_1_100.test_61_70.test64_2.User;
import com.spring_1_100.test_61_70.test64_2.UserService;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test64_args {



    // args
    // 1.任何一个以接受“传入参数类型为 java.io.Serializable” 开头，且其后可跟任意个任意类型的参数的方法执行，args指定的参数类型是在运行时动态匹配的
    //@Pointcut("args(java.io.Serializable,..)")
    @Test
    public void target1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");

        System.out.println("===========================");
        UserService userService = ac.getBean(UserService.class);

        userService.testArgs2(new Model(),"83982");
        System.out.println("===========================");
        userService.getUser();
    }

    //2.任何一个只接受一个参数的方法，且方法运行时传入的参数持有注解 cn.javass.spring.chapter6.Secure；动态切入点，类似于arg指示符；
    //@Pointcut("@args(com.spring_1_100.test_61_70.test64_2.MyAnnotation,..)")
    @Test
    public void target2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("===========================");
        UserService userService = ac.getBean(UserService.class);
        userService.testArgs1(new Model());
        System.out.println("===========================");
        userService.getUserInfo(new User());
    }
}
