package com.spring_1_100.test_91_100.test99_job;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class CronTriggerRunner {

    public static void main(String[] args) throws Exception {
        // 1 通过这种方式注册的trigger必须己经指定了Job组名和Job名，否则调用scheduleJob(simpleTrigger)方法将抛出异常。
        // 2 引用JobDetail对象必须存在于Scheduler中，即代码先后的顺序不能变动。
        JobDetail jobDetail = new JobDetailImpl("job_1_1", "jgroup1", SimpleJob.class);
        CronTrigger cronTrigger = new CronTriggerImpl("trigger1_1", "tgroup1","0/5 * * * * ?");



        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();

    }
}
