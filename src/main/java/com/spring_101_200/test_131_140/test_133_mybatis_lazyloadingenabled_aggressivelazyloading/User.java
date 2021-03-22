package com.spring_101_200.test_131_140.test_133_mybatis_lazyloadingenabled_aggressivelazyloading;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private Long id;
    private String realName;
    private List<UserBill> billList;

}
