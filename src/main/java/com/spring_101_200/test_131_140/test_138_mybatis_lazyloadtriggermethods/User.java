package com.spring_101_200.test_131_140.test_138_mybatis_lazyloadtriggermethods;

import lombok.Data;

import java.util.List;


@Data
public class User {
    private Long id;
    private String realName;
    private List<UserBill> billList;

}
