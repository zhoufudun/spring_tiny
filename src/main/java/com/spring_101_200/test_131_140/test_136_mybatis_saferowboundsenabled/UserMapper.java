package com.spring_101_200.test_131_140.test_136_mybatis_saferowboundsenabled;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserMapper {

    void insertUser(User user);

   User getUser(Long id);

   UserBillInfo selectUserBill(@Param("id") Long id, @Param("rowBounds") RowBounds rowBounds);

   UserBillInfo selectUserBillResultType(@Param("id") Long id);

    List<UserBillInfo> selectUserBills(@Param("id") long id, @Param("rowBounds") RowBounds rowBounds);
}
