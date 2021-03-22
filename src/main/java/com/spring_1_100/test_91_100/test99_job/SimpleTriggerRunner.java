package com.spring_1_100.test_91_100.test99_job;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class SimpleTriggerRunner {

    public static void main(String[] args) throws Exception {
        // 1 通过这种方式注册的trigger必须己经指定了Job组名和Job名，否则调用scheduleJob(simpleTrigger)方法将抛出异常。
        // 2 引用JobDetail对象必须存在于Scheduler中，即代码先后的顺序不能变动。
        JobDetail jobDetail = new JobDetailImpl("job_1_1", "jgroup1", SimpleJob.class);
        SimpleTrigger simpleTrigger = new SimpleTriggerImpl("trigger1_1", "tgroup1",100,5000);

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        scheduler.start();

    }
}
