package com.spring_101_200.test_131_140.test_138_mybatis_lazyloadtriggermethods;

import lombok.Data;

import java.util.List;


@Data
public class User {
    private Long id;
    private String realName;
    private List<UserBill> billList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<UserBill> getBillList() {
        return billList;
    }

    public void setBillList(List<UserBill> billList) {
        this.billList = billList;
    }
}
