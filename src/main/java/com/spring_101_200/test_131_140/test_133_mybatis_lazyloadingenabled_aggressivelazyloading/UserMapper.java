package com.spring_101_200.test_131_140.test_133_mybatis_lazyloadingenabled_aggressivelazyloading;

public interface UserMapper {

    User findUserById(Long id );

    UserBill findUserBillLazyLoading(Long id );

    UserBill selectUserBill(Long id );
}
