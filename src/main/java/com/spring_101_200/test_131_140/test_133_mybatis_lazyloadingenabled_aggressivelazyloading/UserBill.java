package com.spring_101_200.test_131_140.test_133_mybatis_lazyloadingenabled_aggressivelazyloading;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserBill {
    private Long id;
    private String type;
    private Long userId;
    private BigDecimal amount;
    private User user;

}
