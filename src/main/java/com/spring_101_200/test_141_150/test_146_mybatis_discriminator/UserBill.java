package com.spring_101_200.test_141_150.test_146_mybatis_discriminator;


import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class UserBill {
    private Long id;
    private Integer isDelete;
    private String type;
    private Long userId;
    private BigDecimal amount;
    private User user;

}
