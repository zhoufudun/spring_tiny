package com.spring_1_100.test_41_50.test43;


import org.springframework.beans.factory.annotation.Qualifier;

public class Student extends User {
    public void showMe() {
        System.out.println("i am student ");
    }
}