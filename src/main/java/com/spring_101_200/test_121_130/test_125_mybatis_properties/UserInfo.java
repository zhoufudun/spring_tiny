package com.spring_101_200.test_121_130.test_125_mybatis_properties;


import com.spring_101_200.test_131_140.test_133_mybatis_lazyloadingenabled_aggressivelazyloading.UserBill;
import lombok.Data;

import java.util.List;

@Data
public class UserInfo {

    private Long id;
    private String realName;
    private List<UserBill> billList;


}
