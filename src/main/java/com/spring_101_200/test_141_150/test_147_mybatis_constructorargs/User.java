package com.spring_101_200.test_141_150.test_147_mybatis_constructorargs;

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
    private Long userId;



    public User(Long id, Integer isDelete) {
        this.id = id;
        this.isDelete = isDelete;
    }
}
