package com.spring_1_100.test_1_10.test2;


import org.springframework.stereotype.Component;

@Component
public class Piano implements Instrument {
    @Override
    public void play() {
        System.out.println("xxxxxxxxxxxxxxxx");
    }
}
