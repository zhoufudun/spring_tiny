package com.spring_101_200.test_101_110.test101_methodinvokingjobdetail;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test101 {

    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_101_200/config_101_110/spring101_methodinvokingjobdetail.xml");
        CronTrigger cronTrigger = new CronTriggerImpl("trigger1_1", "tgroup1","0/5 * * * * ?");
        JobDetail jobDetail = (JobDetail) ctx.getBean("jobDetail");

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();


    }
}
