package com.spring_101_200.test_161_170.test_164_tx_out_none_exception_inner_supports;

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

    public User(Long id ,String username, String password) {
        this.id = id ;
        this.username = username;
        this.password = password;
    }


}
