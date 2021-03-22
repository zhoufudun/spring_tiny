package com.spring_101_200.test_101_110.test102_simpletrigger_factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class ScheduleConfig {




    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setDataSource(dataSource);

        String schedue = "Test2InyouSinaScheduler";

        //quartz参数
        Properties prop = new Properties();
        prop.put("org.quartz.scheduler.instanceName", schedue);
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        //线程池配置
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "100");
        prop.put("org.quartz.threadPool.threadPriority", "6");
        //JobStore配置
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        //集群配置
        prop.put("org.quartz.jobStore.isClustered", "true");
        prop.put("org.quartz.jobStore.clusterCheckinInterval", "30000");
        prop.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");

        // 当前时超过已安排时间多久的作业不执行
        prop.put("org.quartz.jobStore.misfireThreshold", "125000");
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        factory.setQuartzProperties(prop);

        factory.setSchedulerName(schedue);
        //延时启动
        factory.setStartupDelay(30);
        // 用户可以将Spring ApplicationContext 的引用保存到JobDataMap 中，以便在Job的代码中访问ApplicationContext
        // 为了达到这个上的，用户需要指定一个键，用以在jobDataAsMap中保存ApplicationContext ，如果不设置此键，SchedulerFactoryBean
        // 就不将ApplicationContext 放到JobDataMap中。
        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
        //可选，QuartzScheduler 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
        factory.setOverwriteExistingJobs(true);
        //设置自动启动，默认为true
        factory.setAutoStartup(true);

        return factory;
    }
    


}
