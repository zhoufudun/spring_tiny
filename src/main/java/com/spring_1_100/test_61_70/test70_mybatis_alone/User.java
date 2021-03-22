package com.spring_1_100.test_61_70.test70_mybatis_alone;

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

}
