package com.spring_101_200.test_101_110.test108_mytestbean;

import org.junit.Test;
import org.springframework.beans.BeanMetadataAttribute;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import javax.sound.midi.Soundbank;

public class Test108 {

    @Test
    public void test() {
        XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring_101_200/config_101_110/spring108_mytestbean.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        BeanDefinition beanDefinition = bf.getBeanDefinition("myTestBean");
        Object a = beanDefinition.getAttribute("testStr");
        System.out.println(a );
        System.out.println(bean.getTestStr());
    }

    // 1）、根据基于XML配置中的<qualifier>标签指定的名字进行注入，使用如下方式指定名称：
    @Test
    public void autowiredTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_101_200/config_101_110/spring108_mytestbean1.xml");
        TestBean bean = ctx.getBean("testBean", TestBean.class);
        DataSource dataSource = bean.getDataSource();
        if(dataSource instanceof MysqlDriveManagerDataSource){
            System.out.println("mysql");
        }else if(dataSource instanceof OracleDriveManagerDataSource){
            System.out.println("oracle");
        }
        dataSource.connection();
    }


    @Test
    public void autowiredTest1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_101_200/config_101_110/spring108_mytestbean1.xml");
        try{
            ctx.getBean("mysqlDataSource");
        }catch(Exception e){
            if(e instanceof NoSuchBeanDefinitionException){
                System.out.println("@Qualifier不能作为Bean的标识符");
            }
            e.printStackTrace();
        }
    }


    /**
     * 缺省的根据Bean名字注入：最基本方式，是在Bean上没有指定<qualifier>标签时一种容错机制，即缺省情况下使用Bean标识符注入，但如果你指定了<qualifier>标签将不会发生容错。
     */
    @Test
    public void autowiredTestxxxxx(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_101_200/config_101_110/spring108_mytestbean2.xml");
        TestBean2 bean = ctx.getBean("testBean2", TestBean2.class);
        DataSource dataSource = bean.getDataSource();
        if(dataSource instanceof MysqlDriveManagerDataSource){
            System.out.println("mysql");
        }else if(dataSource instanceof OracleDriveManagerDataSource){
            System.out.println("oracle");
        }
        dataSource.connection();
    }

    //（3）、扩展@Qualifier限定描述符注解(不带参数)：对@Qualifier的扩展来提供细粒度选择候选者；

    /**
     * 具体使用方式就是自定义一个注解并使用@Qualifier注解其即可使用。
     * 首先让我们考虑这样一个问题，如果我们有两个数据源，分别为Mysql和Oracle，因此注入两者相关资源时就牵扯到数据库相关，
     * 如在DAO层注入SessionFactory时，当然可以采用前边介绍的方式，但为了简单和直观我们希望采用自定义注解方式。
     * 1、扩展@Qualifier限定描述符注解来分别表示Mysql和Oracle数据源
     */
    @Test
    public void autowiredTest3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_101_200/config_101_110/spring108_mytestbean3.xml");
        TestBean3 bean = ctx.getBean("testBean3",TestBean3.class);
        DataSource dataSource = bean.getMysqlDataSource();
        if(dataSource instanceof MysqlDriveManagerDataSource){
            System.out.println("mysql");
        }else if(dataSource instanceof OracleDriveManagerDataSource){
            System.out.println("oracle");
        }
        dataSource.connection();
    }

    //（3）、扩展@Qualifier限定描述符注解(带参数)：对@Qualifier的扩展来提供细粒度选择候选者；
    @Test
    public void autowiredTest4(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_101_200/config_101_110/spring108_mytestbean4.xml");
        TestBean4 bean = ctx.getBean("testBean4",TestBean4.class);
        DataSource dataSource = bean.getOracleDataSource();
        if(dataSource instanceof MysqlDriveManagerDataSource){
            System.out.println("mysql");
        }else if(dataSource instanceof OracleDriveManagerDataSource){
            System.out.println("oracle");
        }
        dataSource.connection();
    }

}
