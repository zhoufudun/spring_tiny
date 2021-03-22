package com.spring_1_100.test_61_70.test64_2.test;

import com.spring_1_100.test_61_70.test64_2.*;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

//    https://blog.csdn.net/wangpeng047/article/details/8556800
public class Test64_excution {


    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        Car car = ac.getBean(Car.class);
        car.driver();
    }


    @Test
    //1.@Pointcut("execution(* com.spring_1_100.test_61_70.test64_2.*.*(..))")
    //2.@Pointcut("execution(public * *(..))")                                                            //任何公共方法的执行
    //3.@Pointcut("execution(* com..UserService.*())")                                                    //com 包及所有子包下UserService接口中的任何无参方法
    //4.@Pointcut("execution(* com.spring_1_100.test_61_70..*.*(..))")                                    //com.spring_1_100 包及所有子包下任何类的任何方法
    //5.@Pointcut("execution(* (!com.spring_1_100..UserService+).*(..))")                                 //非“com.spring_1_100 包及所有子包下UserService接口及子类型”的任何方法
    //6.@Pointcut("execution(* com.spring_1_100..UserService+.*())")                                      //com.spring_1_100 包及所有子包下 UserService 接口及子类型的的任何无参方法
    public void test1_6() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("===========================");
        Car car = ac.getBean(Car.class);
        car.driver();
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUserName();
        System.out.println("=============================");
        userService.login("李四");

    }


    @Test
    //7.com.spring_1_100 包及所有子包下UserService前缀类型的的以test开头的只有一个参数类型为java.util.Date的方法，
    // 注意该匹配是根据方法签名的参数类型进行匹配的，而不是根据执行时传入的参数类型决定的如定义方法：public void test(Object obj);
    // 即使执行时传入java.util.Date，也不会匹配的；
    //@Pointcut("execution(* com.spring_1_100..UserServ*.test*(java.util.Date))")
    public void test7() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.testBirth(new Date());
        System.out.println("=============================");
        userService.testObject(new Date());

    }


    @Test
    //8.com.spring_1_100 包及所有子包下UserSe前缀类型的的任何方法，且抛出IllegalArgumentException和ArrayIndexOutOfBoundsException异常，需要同时抛出
    //@Pointcut("execution(* com.spring_1_100..UserSe*.test*(..) throws IllegalArgumentException, ArrayIndexOutOfBoundsException)")
    public void test8() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.testException(new Date());
        System.out.println("=============================");
        userService.testIllegalArgumentException();

    }


    @Test
    //9. 任何实现了com.spring_1_100 包及所有子包下 UserService 接口和java.io.Serializable接口的类型的任何方法
    // @Pointcut("execution(* (com.spring_1_100..UserService+&& java.io.Serializable+).*(..))")
    public void test9() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.testException(new Date());
        System.out.println("=============================");
        UserLogService userLogService = ac.getBean(UserLogService.class);
        userLogService.getLog();

    }


    @Test
    //10.任何持有@java.lang.Deprecated注解的方法
    //@Pointcut("execution(@java.lang.Deprecated * *(..))")
    public void test10() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.testIllegalArgumentException();
        System.out.println("===========================");
        userService.testDeprecated();
    }


    @Test
    //11.任何持有@java.lang.Deprecated和@cn.javass..Secure注解的方法
    //@Pointcut("execution(@java.lang.Deprecated @com.spring_1_100..MyAnnotation * *(..))")
    public void test11() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.testDeprecated();
        System.out.println("===========================");
        userService.testDeprecatedMyAnnotation();
    }

    @Test
    //12.任何持有@java.lang.Deprecated或@com.spring_1_100..MyAnnotation注解的方法
    //@Pointcut("execution(@(java.lang.Deprecated || com.spring_1_100..MyAnnotation) * *(..))")
    public void test12() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.testDeprecated();
        System.out.println("===========================");
        userService.testDeprecatedMyAnnotation();
    }


    @Test
    //13. 任何返回值类型持有@cn.javass..Secure的方法
    //@Pointcut("execution((@com.spring_1_100..MyAnnotation *) *(..))")
    public void test13() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUser();
        System.out.println("===========================");
        userService.getAge();
    }


    @Test
    //14.任何定义方法的类型持有@com.spring_1_100..MyAnnotation的方法 【这个目前有问题，没有测试出来】
    //@Pointcut("execution(* (@com.spring_1_100..MyAnnotation *).*(..))")
    public void test14() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getAge();
        System.out.println("===========================");
        userService.getParentName();
    }


    @Test
    //15.任何签名带有两个参数的方法，且这个两个参数都被@ MyAnnotation 标记了，如public void test(@MyAnnotation String str1,@MyAnnotation String str1);
    //@Pointcut("execution(* *(@com.spring_1_100..MyAnnotation (*),@com.spring_1_100..MyAnnotation (*)))")
    public void test15() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUser("张三", "123456");
        System.out.println("===========================");
        userService.getAge("李四", "83928392");
    }


    //16.任何带有一个参数的方法，且该参数类型持有@com.spring_1_100..MyAnnotation；如public void getUserInfo(User user);且User类上持有@MyAnnotation注解
    //@Pointcut("execution(* *(@com.spring_1_100..MyAnnotation *))")
    @Test
    public void test16() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUserInfo(new User());
        System.out.println("===========================");
        userService.getAge("李四", "83928392");
    }

    //17.任何带有两个参数的方法，且这两个参数都被@com.spring_1_100..MyAnnotation标记了；且这两个参数的类型上都持有@com.spring_1_100..MyAnnotation
    //@Pointcut("execution(* *(@com.spring_1_100..MyAnnotation (@com.spring_1_100..MyAnnotation *),@com.spring_1_100..MyAnnotation (@com.spring_1_100..MyAnnotation  *)))")

    //@Before("execution(* *(@com..MyAnnotation (@com..MyAnnotation *),@com..MyAnnotation (@com..MyAnnotation  *)))")
    @Test
    public void test17() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        userService.getUserHomeWork(new User(), new User());
        System.out.println("=============================");
        userService.getUserHomeInfo(new User(), new User());

    }


    //18.任何带有一个java.util.Map参数的方法，且该参数类型是以<  cn.javass..Model, cn.javass..Model >为泛型参数；注意只匹配第一个参数为java.util.Map,不包括子类型；
    // 如public void test(HashMap<Model, Model> map, String str);将不匹配，必须使用“* *(java.util.HashMap<cn.javass..Model,cn.javass..Model>, ..)”
    // 进行匹配；而public void test(Map map, int i);也将不匹配，因为泛型参数不匹配
    // @Pointcut("execution(* *(java.util.Map<com.spring_1_100..Model, com.spring_1_100..Model>, ..))")
    @Test
    public void test18() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
        System.out.println("============================");
        UserService userService = ac.getBean(UserService.class);
        Map<Model, Model> modelModelMap = new HashMap<>();
        userService.testModel(modelModelMap,"a");
        System.out.println("=============================");
        userService.testModel1("a",modelModelMap);
        System.out.println("=============================");
        userService.testModel2(modelModelMap,"a");
    }


    //19.任何带有一个参数（类型为java.util.Collection）的方法，且该参数类型是有一个泛型参数，该泛型参数类型上持有
    // @com.spring_1_100..MyAnnotation注解；如public void test(Collection<Model> collection);Model类型上持有@com.spring_1_100..MyAnnotation
    // @Pointcut("execution(* *(java.util.Collection<@com.spring_1_100..MyAnnotation *>))")
    @Test
    public void test19() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring64_2.xml");
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
