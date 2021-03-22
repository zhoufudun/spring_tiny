package com.spring_101_200.test_131_140.test_138_mybatis_lazyloadtriggermethods;

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
