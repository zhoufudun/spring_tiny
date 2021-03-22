package com.spring_101_200.test_141_150.test_146_mybatis_discriminator;

import com.spring_101_200.test_131_140.test_133_mybatis_lazyloadingenabled_aggressivelazyloading.User;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Bill {
    private Long id;
    private String type;
    private Long userId;
    private BigDecimal amount;
    private User user;
}
