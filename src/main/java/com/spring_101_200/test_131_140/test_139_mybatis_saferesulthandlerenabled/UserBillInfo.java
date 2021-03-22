package com.spring_101_200.test_131_140.test_139_mybatis_saferesulthandlerenabled;

import lombok.Data;

import java.util.List;

@Data
public class UserBillInfo {
    private Long id;
    private List<Bill> billList;
}
