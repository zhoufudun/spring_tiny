package com.spring_101_200.test_141_150.test_146_mybatis_discriminator;

import lombok.Data;

import java.util.Date;
import java.util.List;

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
    private List<Bill> bills;
    private DateInfo dateInfo;
}
