package com.spring_101_200.test_131_140.test_132_mybatis_typehandlers;

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
