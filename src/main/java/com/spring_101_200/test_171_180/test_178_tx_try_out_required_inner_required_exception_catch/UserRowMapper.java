package com.spring_101_200.test_171_180.test_178_tx_try_out_required_inner_required_exception_catch;

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
