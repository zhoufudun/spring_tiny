package com.spring_101_200.test_181_190.test_182_tx_out_required_inner_required;

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
