package com.spring_101_200.test_101_110.test102_simpletrigger_factorybean;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;

import java.util.Map;

public class MyJob implements StatefulJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Map dataMap = context.getTrigger().getJobDataMap();
        String count = (String) dataMap.get("count");
        System.out.println(count);

    }
}
