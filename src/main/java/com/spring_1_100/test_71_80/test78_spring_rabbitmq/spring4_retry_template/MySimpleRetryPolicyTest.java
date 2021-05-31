package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring4_retry_template;

import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

public class MySimpleRetryPolicyTest {

    public static void main(String[] args) throws Exception,Throwable {
        RetryTemplate retryTemplate = new RetryTemplate();
        //指数退避策略 等待时间= 等待时间*倍数 ，即每一次的等待时间是上一次等待时间的n倍，
        //到达最大的等待时间之后就不在增加了，一直都是以最大的等待时间在等待。默认执行3次
        ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
        //初始等待时间
        exponentialBackOffPolicy.setInitialInterval(1000);
        //时间等待倍数
        exponentialBackOffPolicy.setMultiplier(2);
        //最大等待时间
        exponentialBackOffPolicy.setMaxInterval(5000);
        retryTemplate.setBackOffPolicy(exponentialBackOffPolicy);
        retryTemplate.setRetryPolicy(new MySimpleRetryPolicy());
        String execute = retryTemplate.execute(new RetryCallback<String, Throwable>() {
            @Override
            public String doWithRetry(RetryContext context) throws Throwable {
                if(context.getRetryCount() > 2 ){
                    //需要重试的代码
                    System.out.println("开始执行NullPointerException======" + context.getRetryCount());
                    throw new NullPointerException();
                }
                //需要重试的代码
                System.out.println("开始执行TimeoutException======" +  context.getRetryCount());
                throw new TimeoutException();
            }
        }, new RecoveryCallback<String>() {
            @Override
            public String recover(RetryContext context) throws Exception {
                //重试失败后执行的代码
                return "failed callback";
            }
        });

        System.out.println(execute);
    }
}
