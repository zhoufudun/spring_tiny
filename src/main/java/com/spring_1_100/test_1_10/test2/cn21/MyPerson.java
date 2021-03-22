package com.spring_1_100.test_1_10.test2.cn21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyPerson {

    @Autowired
    private Person person;

    public Person getPerson() {
        return person;
    }


}
