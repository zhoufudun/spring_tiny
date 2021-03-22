package com.spring_1_100.test_91_100.test99_job;

import com.spring_1_100.test_41_50.test43.GetBeanTest;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class CalendarExample {
    public static void main(String[] args)  throws Exception{
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        AnnualCalendar holidays = new AnnualCalendar();
        Calendar laborday = new GregorianCalendar();
        laborday.add(Calendar.MONTH,5);
        laborday.add(Calendar.DATE,1);
        holidays.setDayExcluded(laborday,true);

        Calendar nationalDay = new GregorianCalendar();
        nationalDay.add(Calendar.MONTH,7);
        nationalDay.add(Calendar.DATE,22);
        holidays.setDayExcluded(nationalDay,true);

        scheduler.addCalendar("holidays",holidays,false,false);

        Date runDate = new Date();
        JobDetail jobDetail = new JobDetailImpl("job_1_1", "jgroup1", SimpleJob.class);
        SimpleTrigger trigger = new SimpleTriggerImpl("trigger1","group1",runDate,null,SimpleTrigger.REPEAT_INDEFINITELY,2000);
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
