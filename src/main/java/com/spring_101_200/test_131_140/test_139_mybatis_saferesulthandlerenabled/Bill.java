package com.spring_101_200.test_131_140.test_139_mybatis_saferesulthandlerenabled;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Bill {
    private Long id;
    private String type;
    private Long userId;
    private BigDecimal amount;

}
