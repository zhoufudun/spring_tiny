package com.spring_101_200.test_111_120.test_117_excution.excution19;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;


public class Test117_excution19 {
//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring_117_excution/spring_117_excution13.xml");


    //19.任何带有一个参数（类型为java.util.Collection）的方法，且该参数类型是有一个泛型参数，该泛型参数类型上持有
    // @com.spring_1_100..MyAnnotation注解；如public void test(Collection<Model> collection);Model类型上持有@com.spring_1_100..MyAnnotation
    // @Pointcut("execution(* *(java.util.Collection<@com.spring_1_100..MyAnnotation *>))")
    @Test
    public void test19() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution19.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        Collection<User> users = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        List<Model> models = new ArrayList<>();
        System.out.println("============================");
        userService.testMyCollection(users);
        System.out.println("============================");
        userService.testMyUser(userList);
        System.out.println("============================");
        userService.testMyModel(models);
    }

}
