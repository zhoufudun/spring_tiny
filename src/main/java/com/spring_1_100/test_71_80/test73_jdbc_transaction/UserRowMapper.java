package com.spring_1_100.test_71_80.test73_jdbc_transaction;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(
                rs.getString("username"),
                rs.getString("password")
                );
        return user;
    }
}
