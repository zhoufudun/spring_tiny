package com.spring_101_200.test_121_130.test_128_mybatis_objectfactory;

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


    public void init(){
        System.out.println("user init ");
    }

}
