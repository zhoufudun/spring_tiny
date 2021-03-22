package com.spring_101_200.test_151_160.test_153_mybatis_self_typehandler;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private Integer isDelete;
    private Date gmtCreate;
    private Date gmtModified;
    private PhoneNumber username;
    private String password;
    private String realName;
    private Long managerId;

}
