package com.spring_101_200.test_101_110.test102_simpletrigger_factorybean;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test102 {

    @Test
    public void test1() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_101_200/config_101_110/spring102_simple_triggger_factory_bean.xml");
        JobDetail jobDetail = (JobDetail) ctx.getBean("jobDetail");
        SimpleTrigger simpleTrigger = (SimpleTrigger) ctx.getBean("simpleTrigger");

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        scheduler.start();

        Thread.sleep(200000);

    }


    @Test
    public void test2() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_101_200/config_101_110/spring102_simple_triggger_factory_bean.xml");
        JobDetail jobDetail = (JobDetail) ctx.getBean("jobDetail");
        CronTrigger cronTrigger = (CronTrigger) ctx.getBean("checkImagesTrigger");

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();

        Thread.sleep(200000);


    }
}
