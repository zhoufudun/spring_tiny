package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring4_retry_template;

import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.context.RetryContextSupport;

import java.util.HashSet;
import java.util.Set;

public class MySimpleRetryPolicy implements RetryPolicy {

    private int maxCount = 5;

    @Override
    public boolean canRetry(RetryContext context) {
        MySimpleRetryContext mySimpleRetryContext = (MySimpleRetryContext) context;
        if(mySimpleRetryContext.getRetryCount() > maxCount){
            return false;
        }
        for(Throwable throwable : mySimpleRetryContext.getThrowables()){
            if(throwable instanceof NullPointerException){
                return false;
            }
            if(throwable instanceof TimeoutException){
                return true;
            }
        }
        return true;
    }

    @Override
    public RetryContext open(RetryContext parent) {
        return new MySimpleRetryContext(parent);
    }

    @Override
    public void close(RetryContext context) {

    }

    @Override
    public void registerThrowable(RetryContext context, Throwable throwable) {
        MySimpleRetryContext mySimpleRetryContext = (MySimpleRetryContext) context;
        mySimpleRetryContext.addThrowables(throwable);
        mySimpleRetryContext.registerThrowable(throwable);
    }

    public class MySimpleRetryContext extends RetryContextSupport {
        private Set<Throwable> throwables = new HashSet<>();


        public MySimpleRetryContext(RetryContext parent) {
            super(parent);
        }

        public Set<Throwable> getThrowables() {
            return throwables;
        }

        public void addThrowables(Throwable throwable) {
            this.throwables.add(throwable);
        }
    }


}
