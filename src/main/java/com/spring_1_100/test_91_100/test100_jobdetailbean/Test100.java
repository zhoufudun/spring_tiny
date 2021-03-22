package com.spring_1_100.test_91_100.test100_jobdetailbean;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test100 {

    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1_100/config_91_100/spring100_jobdetaibean.xml");
        CronTrigger cronTrigger = new CronTriggerImpl("trigger1_1", "tgroup1","0/5 * * * * ?");
        JobDetail jobDetail = (JobDetail) ctx.getBean("jobDetail");

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();
    }
}
