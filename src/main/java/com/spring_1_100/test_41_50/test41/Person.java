package com.spring_1_100.test_41_50.test41;

import lombok.Data;

@Data
public class Person {

    private Integer age;
    private Number sex;

    public Person() {
    }
    public Person(Number sex) {
        this.sex = sex;
    }

    public Person(Integer age) {
        this.age = age;
    }


}
