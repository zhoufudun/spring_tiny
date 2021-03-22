package com.spring_101_200.test_121_130.test_125_mybatis_properties;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserBill {
    private Long id;
    private String type;
    private Long userId;
    private BigDecimal amount;
    private String name;
    private User user ;



}
