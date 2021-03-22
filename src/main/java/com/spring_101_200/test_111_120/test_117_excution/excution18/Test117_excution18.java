package com.spring_101_200.test_111_120.test_117_excution.excution18;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;


public class Test117_excution18 {
//ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring_117_excution/spring_117_excution13.xml");




    //18.任何带有一个java.util.Map参数的方法，且该参数类型是以<  cn.javass..Model, cn.javass..Model >为泛型参数；注意只匹配第一个参数为java.util.Map,不包括子类型；
    // 如public void test(HashMap<Model, Model> map, String str);将不匹配，必须使用“* *(java.util.HashMap<cn.javass..Model,cn.javass..Model>, ..)”
    // 进行匹配；而public void test(Map map, int i);也将不匹配，因为泛型参数不匹配
    // @Pointcut("execution(* *(java.util.Map<com.spring_1_100..Model, com.spring_1_100..Model>, ..))")
    @Test
    public void test18() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution18.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        Map<Model, Model> modelModelMap = new HashMap<>();
        userService.testModel(modelModelMap,"a");
        System.out.println("=============================");
        userService.testModel1("a",modelModelMap);
        System.out.println("=============================");
        userService.testModel2(modelModelMap,"a");
    }

}
