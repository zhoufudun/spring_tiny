package com.spring_1_100.test_61_70.test69_database;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private Integer isDelete;
    private Date gmtCreate;
    private Date gmtModified;
    private String username;
    private String password;
    private String realName;
    private Long managerId;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
