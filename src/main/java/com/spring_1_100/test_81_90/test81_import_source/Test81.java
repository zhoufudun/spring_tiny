package com.spring_1_100.test_81_90.test81_import_source;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test81 {

    /***
     * Bean 的定义，
     * 在XML文件中通过<bean>元素定义Bean ,如<bean class="com.bbt.UserDao"/>
     * 通过@Bean 的initMethod 或destoryMethod 指定一个初始化或者销毁方法。
     * 对于初始化方法来说，你可以直接在方法的内部通过代码的方式灵活定义初始化逻辑
     * bean 的作用范围，通过<bean> 的scope 属性指定：如<bean class="com.bbt.UserDao" scope="prototype">
     * 基于XML配置：1)Bean 实现类来源于第三方类库，如DataSource ,JDBCTemplate 等因素，无法在类中标注注解，通过XML配置方式较好
     * 2)命名空间的配置，如aop ,context 等，只能采用基于XML 配置
     * 基于注解的配置：Bean 的实现类当前项目开发的，可以直接在Java 类中使用基于注解的配置
     * 基于java的配置：基于java类配置的优势在于可以通过代码方式控制bean的初始化整体逻辑，所以如果实例化Bean的逻辑比较复杂的时候，则比较适合
     * 基于java类配置方式。
     *
     *
     */
    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(LogonAppConfig.class);
        LogDao logDao = ac.getBean(LogDao.class);
        System.out.println(logDao);
    }
}
