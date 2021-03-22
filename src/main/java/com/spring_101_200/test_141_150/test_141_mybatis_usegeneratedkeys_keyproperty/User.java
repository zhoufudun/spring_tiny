package com.spring_101_200.test_141_150.test_141_mybatis_usegeneratedkeys_keyproperty;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private int isDelete;
    private Date gmtCreate;
    private Date gmtModified;
    private String username;
    private String password;
    private String realName;
    private Long managerId;
    private Integer sex;
    private String sexStr;

}
