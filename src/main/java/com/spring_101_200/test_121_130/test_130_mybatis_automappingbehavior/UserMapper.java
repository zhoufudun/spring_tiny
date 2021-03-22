package com.spring_101_200.test_121_130.test_130_mybatis_automappingbehavior;

public interface UserMapper {

    void insertUser(User user);

   User getUser(Long id);

   UserBillInfo selectUserBill(Long id);
}
