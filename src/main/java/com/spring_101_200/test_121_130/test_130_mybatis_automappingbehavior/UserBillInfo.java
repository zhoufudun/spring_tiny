package com.spring_101_200.test_121_130.test_130_mybatis_automappingbehavior;

import lombok.Data;

import java.util.List;

@Data
public class UserBillInfo {
    private Long id;
    private List<Bill> billList;
}
