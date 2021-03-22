package com.spring_101_200.test_151_160.test_153_mybatis_self_typehandler;

import lombok.Data;

@Data
public class PhoneNumber {

    private String phone ;

    public PhoneNumber() {

    }

    public PhoneNumber(String phone) {
        this.phone = phone;
    }
}
