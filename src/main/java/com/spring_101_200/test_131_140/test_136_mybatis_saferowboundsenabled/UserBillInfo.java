package com.spring_101_200.test_131_140.test_136_mybatis_saferowboundsenabled;

import lombok.Data;

import java.util.List;

@Data
public class UserBillInfo {
    private Long id;
    private List<Bill> billList;
}
