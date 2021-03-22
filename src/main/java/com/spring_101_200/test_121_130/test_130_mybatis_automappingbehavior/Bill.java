package com.spring_101_200.test_121_130.test_130_mybatis_automappingbehavior;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Bill {
    private Long id;
    private String type;
    private Long userId;
    private BigDecimal amount;

}
