package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring4_retry_template;

import org.springframework.retry.*;
import org.springframework.retry.support.RetryTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyRetryTemplate extends RetryTemplate {
    
    protected <T, E extends Throwable> T doExecute(RetryCallback<T, E> retryCallback,
                                                   RecoveryCallback<T> recoveryCallback, RetryState state) throws E, ExhaustedRetryException {
        RetryCallback myRetryCallback = new RetryCallback<String, Throwable>() {
            @Override
            public String doWithRetry(RetryContext context) throws Throwable {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //需要重试的代码
                System.out.println("开始执行======"  + df.format(new Date()));
                throw new TimeoutException();

            }
        };
        RecoveryCallback myRecoveryCallback = new RecoveryCallback<String>() {
            @Override
            public String recover(RetryContext context) throws Exception {
                //重试失败后执行的代码
                System.out.println("failed callback======");
                return "failed callback";
            }
        };
        return (T) super.doExecute(myRetryCallback, myRecoveryCallback, state);
    }
}
