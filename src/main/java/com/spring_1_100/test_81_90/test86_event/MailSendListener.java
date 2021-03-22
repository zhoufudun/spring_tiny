package com.spring_1_100.test_81_90.test86_event;

import org.springframework.context.ApplicationListener;

public class MailSendListener implements ApplicationListener<MailSendEvent> {
    @Override
    public void onApplicationEvent(MailSendEvent event) {
        MailSendEvent mse = (MailSendEvent)event;
        System.out.println("mail SendListener: 向" + mse.getTo() + " 发送完一寺电子件 ") ;
    }
}
