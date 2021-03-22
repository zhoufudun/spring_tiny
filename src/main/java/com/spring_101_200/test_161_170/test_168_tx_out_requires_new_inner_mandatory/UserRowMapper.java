package com.spring_101_200.test_161_170.test_168_tx_out_requires_new_inner_mandatory;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password")
                );
        return user;
    }
}
