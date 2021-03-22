package com.spring_101_200.test_141_150.test_146_mybatis_discriminator;


import lombok.Data;

import java.util.List;

@Data
public class UserBillInfo {
    private Long id;
    private List<Bill> billList;
    private User user;
}
