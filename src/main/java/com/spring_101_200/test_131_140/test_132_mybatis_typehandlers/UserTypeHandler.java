package com.spring_101_200.test_131_140.test_132_mybatis_typehandlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTypeHandler extends BaseTypeHandler<User> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, User parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("=================setNonNullParameter==============");

    }

    @Override
    public User getNullableResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("==================getNullableResult======111=======");
        String username =rs.getString("username");
        System.out.println("username:" + username);
        String password = rs.getString("password");
        System.out.println("password:" + password);
        User user =  new User();
        user.setUsername(new PhoneNumber(username));
        user.setPassword(password);
        return user;
    }

    @Override
    public User getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("================getNullableResult=======22222========");
        return null;
    }

    @Override
    public User getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("================getNullableResult========33333=======");

        return null;
    }
}
