package com.spring_101_200.test_121_130.test_125_mybatis_properties;

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
    private Integer sex;
    private String sexStr;
}
