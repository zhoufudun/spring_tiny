package com.spring_101_200.test_171_180.test_171_tx_out_required_not_supported_exception;

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
