package com.spring_101_200.test_101_110.test104_xstream;

import lombok.Data;

import java.util.Date;


@Data
public class LoginLog {

    private String ip;
    private Date loginDate;
    private Long userId;

}
