package com.spring_1_100.test_91_100.test100_jobdetailbean;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

import javax.sound.midi.Soundbank;
import java.util.Map;

public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 获取jobDetail关联的JobDataMap
        Map dataMap = context.getJobDetail().getJobDataMap();
        String size = (String) dataMap.get("size");
        ApplicationContext ctx = (ApplicationContext) dataMap.get("applicationContext");
        System.out.println(ctx);
        System.out.println(" size = " + size);
        dataMap.put("size",size + "0");


    }
}
