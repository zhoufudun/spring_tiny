package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring4_retry_template;

import org.junit.Test;
import org.springframework.classify.Classifier;
import org.springframework.retry.*;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.backoff.ExponentialRandomBackOffPolicy;
import org.springframework.retry.policy.*;
import org.springframework.retry.support.RetryTemplate;

import java.util.HashMap;
import java.util.Map;

public class RetryTemplatePolicyTest {

    @Test
    public void test1() throws Exception,Throwable {
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

        String execute = retryTemplate.execute(new RetryCallback<String, Throwable>() {
            @Override
            public String doWithRetry(RetryContext context) throws Throwable {
                //需要重试的代码
                System.out.println("开始执行======");
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

    @Test
    public void test2() throws Exception ,Throwable{
        RetryTemplate retryTemplate = new RetryTemplate();
        ExceptionClassifierRetryPolicy policy = new ExceptionClassifierRetryPolicy();

        policy.setExceptionClassifier(new Classifier<Throwable, RetryPolicy>() {
            @Override
            public RetryPolicy classify(Throwable classifiable) {

                if (classifiable instanceof NullPointerException) {
                    //NullPointerException 异常就是SimpleRetryPolicy策略
                    return new SimpleRetryPolicy();
                }
                if (classifiable instanceof TimeoutException) {
                    //如果是TimeoutException 异常就是AlwaysRetryPolicy（一直执行直到成功）策略
                    return new AlwaysRetryPolicy();
                }
                //不执行直接走 RecoveryCallback。recover（）
                return new NeverRetryPolicy();
            }
        });

        retryTemplate.setRetryPolicy(policy);

        String execute = retryTemplate.execute(new RetryCallback<String, Throwable>() {
            @Override
            public String doWithRetry(RetryContext context) throws Throwable {
                //需要重试的代码
                System.out.println("开始执行======");
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


    //通过PolicyMap定义异常及其重试策略。下面的代码在抛出NullPointerException采用NeverRetryPolicy策略，而TimeoutException采用AlwaysRetryPolicy。
    @Test
    public void test3() throws Exception{
        RetryTemplate template = new RetryTemplate();
        ExceptionClassifierRetryPolicy policy = new ExceptionClassifierRetryPolicy();
        Map<Class<? extends Throwable>, RetryPolicy> policyMap = new HashMap<Class<? extends Throwable>, RetryPolicy>();

        policyMap.put(TimeoutException.class, new AlwaysRetryPolicy());
        policyMap.put(NullPointerException.class, new NeverRetryPolicy());
        policy.setPolicyMap(policyMap);

        template.setRetryPolicy(policy);
        String result = template.execute(
                new RetryCallback<String, Exception>() {
                    public String doWithRetry(RetryContext arg0) throws Exception {
                        if(arg0.getRetryCount() >= 2) {
                            Thread.sleep(1000);
                            throw new NullPointerException();
                        }
                        throw new TimeoutException("TimeoutException");
                    }
                }
                ,
                new RecoveryCallback<String>() {
                    public String recover(RetryContext context) throws Exception {
                        return "recovery callback";
                    }
                }
        );
        System.out.println(result);
    }

    @Test

    public void test4() throws Exception{
        RetryTemplate template = new RetryTemplate();

        CompositeRetryPolicy policy = new CompositeRetryPolicy();
        RetryPolicy[] polices = {new SimpleRetryPolicy(), new AlwaysRetryPolicy()};

        policy.setPolicies(polices);
        policy.setOptimistic(true);
        template.setRetryPolicy(policy);

        String result = template.execute(
                new RetryCallback<String, Exception>() {
                    public String doWithRetry(RetryContext arg0) throws Exception {
                        if(arg0.getRetryCount() >= 2) {
                            Thread.sleep(1000);
                            throw new NullPointerException();

                        }
                        throw new TimeoutException("TimeoutException");
                    }
                }
                ,
                new RecoveryCallback<String>() {
                    public String recover(RetryContext context) throws Exception {
                        return "recovery callback";
                    }
                }
        );
        System.out.println(result);
    }

    //下面的代码中创建CompositeRetryPolicy策略，并创建了RetryPolicy数组，数组有两个具体策略SimpleRetryPolicy与
    // AlwaysRetryPolicy。当CompositeRetryPolicy设置optimistic为true时，Spring-retry会顺序遍历RetryPolicy[]数组，
    // 如果有一个重试策略可重试，例如SimpleRetryPolicy没有达到重试次数，那么就会进行重试。 如果optimistic选项设置为false。
    // 那么有一个重试策略无法重试，那么就不进行重试。例如SimpleRetryPolicy达到重试次数不能再重试，而AlwaysRetryPolicy可以重试，
    // 那么最终是无法重试的。
    @Test
    public void test5() throws Exception{
        RetryTemplate template = new RetryTemplate();

        ExponentialRandomBackOffPolicy exponentialBackOffPolicy = new ExponentialRandomBackOffPolicy();
        exponentialBackOffPolicy.setInitialInterval(1500);
        exponentialBackOffPolicy.setMultiplier(2);
        exponentialBackOffPolicy.setMaxInterval(6000);


        CompositeRetryPolicy policy = new CompositeRetryPolicy();
        RetryPolicy[] polices = {new SimpleRetryPolicy(), new AlwaysRetryPolicy()};

        policy.setPolicies(polices);
        policy.setOptimistic(true);

        template.setRetryPolicy(policy);
        template.setBackOffPolicy(exponentialBackOffPolicy);

        template.registerListener(new RetryListener() {

            public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
                System.out.println("open");
                return true;
            }

            public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback,
                                                         Throwable throwable) {

                System.out.println("onError");
            }

            public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback,
                                                       Throwable throwable) {
                System.out.println("close");
            }
        });

        template.registerListener(new RetryListener() {

            public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
                System.out.println("open2");
                return true;
            }

            public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback,
                                                         Throwable throwable) {

                System.out.println("onError2");
            }

            public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback,
                                                       Throwable throwable) {
                System.out.println("close2");
            }
        });
        String result = template.execute(
                new RetryCallback<String, Exception>() {
                    public String doWithRetry(RetryContext arg0) throws Exception {
                        arg0.getAttribute("");
                        if(arg0.getRetryCount() >= 2) {
                            throw new NullPointerException();
                        }
                        throw new TimeoutException("TimeoutException");
                    }
                }
        );
        System.out.println(result);
    }

}
