package com.spring_1_100.test_41_50.test41;

import lombok.Data;

@Data
public class User {

    private String userName;

    private Integer age;

    private Integer sex;


    public User(Integer age, Integer sex) {
        this.age = age;
        this.sex = sex;
    }

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public User() {
    }

    public User(String userName, Integer age, Integer sex) {
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }

}
