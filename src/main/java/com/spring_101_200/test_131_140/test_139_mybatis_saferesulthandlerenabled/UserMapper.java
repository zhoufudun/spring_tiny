package com.spring_101_200.test_131_140.test_139_mybatis_saferesulthandlerenabled;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {



   UserBillInfo selectUserBill(@Param("id") Long id);

}
