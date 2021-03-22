package com.spring_101_200.test_111_120.test_117_excution.excution9;

import com.spring_1_100.test_61_70.test64_2.UserLogService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class Test117_excution9 {



    //9. 任何实现了com.spring_1_100 包及所有子包下 UserService 接口和java.io.Serializable接口的类型的任何方法
    // @Pointcut("execution(* (com.spring_1_100..UserService+&& java.io.Serializable+).*(..))")
    @Test
    public void test7() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution9.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.testException(new Date());
        System.out.println("=============================");
        UserLogService userLogService = ac.getBean(UserLogService.class);
        userLogService.getLog();
    }

}
