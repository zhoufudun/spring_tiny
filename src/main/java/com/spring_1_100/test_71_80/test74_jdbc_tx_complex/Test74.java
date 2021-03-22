package com.spring_1_100.test_71_80.test74_jdbc_tx_complex;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// https://blog.csdn.net/yanyan19880509/article/details/53041564/
public class Test74 {


    @Test
    public void updateUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUser();
    }



    //0========[required[required]]=====result:[rollback[rollback]]========================
    @Test
    public void requiredTest() {

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.requiredTest();




    }



    //1========[requires_new[requires_new-exception]]=====result:[rollback[rollback]]========================
    @Test
    public void updateUserRequiresNewTest1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest1();
    }






    //2========[requires_new-exception[requires_new]]=====result:[rollback[commit]]========================
    @Test
    public void updateUserRequiresNewTest2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest2();
    }

    //3========[required-exception[requires_new]]=====result:[rollback[commit]]========================
    @Test
    public void updateUserRequiresNewTest22() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest22();
    }

    //4========[required[requires_new][requires_new-exception]]=====result:[rollback[commit][rollback]]========================
    @Test
    public void updateUserRequiresNewTest222() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest222();
    }

    //5========[required[required-exception]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresTest1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresTest1();
    }

    //6========[required-exception[required]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresTest2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresTest2();
    }

    //7========[requires_new-exception[required]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresNewTest3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest3();
    }

    //8========[required[requires_new-exception]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresNewTest4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest4();
    }


    //9========[required-exception[supports]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresNewTest5() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest5();
    }
    //10========[none-exception[supports]]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest6() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest6();
    }

    //11========[none[supports-exception]]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest7() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest7();
    }

    //12========[required[supports-exception]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresNewTest8() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest8();
    }



    //13========[requires_new[supports-exception]]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresNewTest9() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest9();
    }


    //14.========[requires_new[mandatory]]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest11() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest11();
    }

    //15========[none[mandatory]]=====result:[commit[exception]]=========================================
    @Test
    public void updateUserRequiresNewTest12() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest12();
    }


    //16========[required][mandatory]=====result:[commit][exception]=========================================
    @Test
    public void updateUserRequiresNewTest13() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest13();
    }







    //17 不同数据========[required[not_supported-exception]]=====result:[rollback[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest14() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest14();
    }


    //18 同一条数据========[required[not_supported-exception]]=====result:[程序被挂起，但是内部的not_supported修改的内容被提交]=========================================
    // org.springframework.dao.CannotAcquireLockException: PreparedStatementCallback;
    // SQL [update lz_user set username = ? where id = ? ]; Lock wait timeout exceeded;
    // try restarting transaction; nested exception is java.sql.SQLException:
    // Lock wait timeout exceeded; try restarting transaction
    @Test
    public void updateUserRequiresNewTest144() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest144();
    }


    //19========[none[not_supported-exception]]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest15() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest15();
    }







    //20========[required[never]]=====result:[exception : Existing transaction found for transaction marked with propagation 'never']=========================================
    @Test
    public void updateUserRequiresNewTest16() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest16();
    }

    //21========[never[required]]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest17() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest17();
    }


    //22========[required try{[nested-exception]}catch ]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest18() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest18();
    }

    //23========required [try{ 1 ,exception, 2 }catch] =====result:[commit , not run]=========================================
    //========required [try{ 1 , 2 ,exception }catch] =====result:[commit , commit]=========================================
    @Test
    public void updateUserRequiresNewTest19() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest19();
    }



    //24========[try{required[required-exception]}catch ]=====result:[rollback[rollback]]=========================================
    @Test
    public void updateUserRequiresNewTest21() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest21();
    }


    //25========[required try{[none-exception]}catch ]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest20() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest20();
    }

    //26========[required[try{required-exception}catch]]=====result:[commit[commit]]=========================================
    @Test
    public void updateUserRequiresNewTest2222() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring74.xml");
        TxService txService = (TxService) ac.getBean("txService");
        txService.updateUserRequiresNewTest2222();
    }

    /**
     * 1. propagation_required
     * 说明： 如果当前已经存在事务，那么加入该事务，如果不存在事务，创建一个事务，这是默认的传播属性值。
     * 2、propagation_supports
     * 说明：如果当前已经存在事务，那么加入该事务，否则创建一个所谓的空事务（可以认为无事务执行）。
     * 3、propagation_mandatory
     * 说明：当前必须存在一个事务，否则抛出异常。
     * 4、propagation_requires_new
     * 说明：如果当前存在事务，先把当前事务相关内容封装到一个实体，然后重新创建一个新事务，接受这个实体为参数，
     * 用于事务的恢复。更直白的说法就是暂停当前事务(当前无事务则不需要)，创建一个新事务。 针对这种情况，两个
     * 事务没有依赖关系，可以实现新事务回滚了，但外部事务继续执行。
     * 5、propagation.not_supported
     * 说明：如果当前存在事务，挂起当前事务，然后新的方法在没有事务的环境中执行，没有spring事务的环境下，
     * sql的提交完全依赖于 defaultAutoCommit属性值 。
     * 6、 propagation_never
     * 说明： 如果当前存在事务，则抛出异常，否则在无事务环境上执行代码。
     * 7、 propagation_nested
     * 说明： 如果当前存在事务，则使用 SavePoint 技术把当前事务状态进行保存，然后底层共用一个连接，当NESTED内部出错的时候，
     * 自行回滚到 SavePoint这个状态，只要外部捕获到了异常，就可以继续进行外部的事务提交，而不会受到内嵌业务的干扰，
     * 但是，如果外部事务抛出了异常，整个大事务都会回滚。
     * 不同的ORM技术都有一套自己的方案以初始化框架，
     *，由于，Spring Dao 异常，事务，资源等高级层建立了抽象，可以让业务层对Dao具体的实现的技术三到敏感，还给开发带来了一个好处，
     * 他们可以在底层先用适合的实现方式甚至可以混合使用多种Dao ，
     * 使用Hibernate框架的第一个工作就是编写Hibernate的配置文件，下一步就是如何使用这些配置文件实例化SessionFactory，创建好的
     * Hibernate的基础设施。
     * Spring 为创建SessionFactory提供了一个好用的FactoryBean工厂类，org.springframework.orm.hibernate3.LocalSessionFactoryBean
     * 通过一些必要的属性，就可以获取一个SessionFactoryBean了
     * LocalSessionFactoryBean配置灵活性很高，支持开发者的不同的习惯，让开发者拥有充分的选择权，这是Spring的一惯风格。
     *
     *
     */


























}
