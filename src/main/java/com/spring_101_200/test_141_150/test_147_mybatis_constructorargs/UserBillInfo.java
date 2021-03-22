package com.spring_101_200.test_141_150.test_147_mybatis_constructorargs;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserBillInfo {
    private Long id;
    private Integer isDelete;

    private DateInfo dateInfo;


    public UserBillInfo(DateInfo dateInfo) {
        this.dateInfo = dateInfo;
    }
    //收支类型
    private String type;
    //用户id
    private Long userId;
    //管理员id
    private Long managerId;
    //
    private BigDecimal amount;
    //备注
    private String remark;
    //账单类型
    private String billType;
    //支付方式
    private String payType;
    //-1表示作费，0表示提交，1表示已经报销
    private Integer status;
    //0表示公开，1表示仅仅自己可见
    private Integer selfLook;

    private User user;

}
