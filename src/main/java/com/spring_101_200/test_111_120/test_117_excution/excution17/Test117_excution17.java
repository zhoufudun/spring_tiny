package com.spring_101_200.test_111_120.test_117_excution.excution17;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test117_excution17 {
//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring_117_excution/spring_117_excution13.xml");


    //17.任何带有两个参数的方法，且这两个参数都被@com.spring_1_100..MyAnnotation标记了；且这两个参数的类型上都持有@com.spring_1_100..MyAnnotation
    //@Pointcut("execution(* *(@com.spring_1_100..MyAnnotation (@com.spring_1_100..MyAnnotation *),@com.spring_1_100..MyAnnotation (@com.spring_1_100..MyAnnotation  *)))")
    @Test
    public void test17() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution17.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUserHomeWork(new User(), new User());
        System.out.println("=============================");
        userService.getUserHomeInfo(new User(), new User());
        System.out.println("=============================");
        userService.getModelInfo(new Model(), new Model());


    }
}
