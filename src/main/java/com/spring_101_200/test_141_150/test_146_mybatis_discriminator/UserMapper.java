package com.spring_101_200.test_141_150.test_146_mybatis_discriminator;


public interface UserMapper {

    User findUserById(Long id);

    UserBill findUserBillLazyLoading(Long id);

    UserBillInfo selectUserBill(Long id );

}
