package com.spring_1_100.test_31_40.test37;

import lombok.Data;

@Data
public class Person {

    private String name ;

    private Integer age ;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
