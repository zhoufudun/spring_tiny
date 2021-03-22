package com.spring_1_100.test_61_70.test62;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;

public class TestListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("=============================");
        System.out.println(event.toString());
        if(event instanceof PayloadApplicationEvent){
            TestEvent testEvent = (TestEvent)((PayloadApplicationEvent) event).getPayload();
            testEvent.print();
        }

    }


}
