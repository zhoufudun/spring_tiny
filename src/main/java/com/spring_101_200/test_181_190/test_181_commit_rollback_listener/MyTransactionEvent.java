package com.spring_101_200.test_181_190.test_181_commit_rollback_listener;

import org.springframework.context.ApplicationEvent;

public class MyTransactionEvent extends ApplicationEvent {
    private String name;

    public MyTransactionEvent(String name, Object source) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
} 