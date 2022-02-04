package com.t2022.t01.t15.t1712;

import lombok.Data;

@Data
public class User {
    private Integer age;

    public static void main(String[] args) {
        User user = new User() ;
        user.setAge(new Integer(1));
        System.out.println(new Integer(1) == user.getAge());
        System.out.println(1 == user.getAge());
    }
}
