package com.spring_1_100.test_81_90.test86_event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class MailSendEvent extends ApplicationContextEvent {
    private String to;
    public MailSendEvent(ApplicationContext source,String to ) {
        super(source);
        this.to = to;
    }

    public String getTo(){
        return this.to;
    }


}
