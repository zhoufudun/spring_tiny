package com.spring_101_200.test_131_140.test_136_mybatis_saferowboundsenabled;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Bill {
    private Long id;
    private String type;
    private Long userId;
    private BigDecimal amount;

}
