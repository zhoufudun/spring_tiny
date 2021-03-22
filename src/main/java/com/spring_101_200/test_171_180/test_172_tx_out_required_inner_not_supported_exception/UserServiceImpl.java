package com.spring_101_200.test_171_180.test_172_tx_out_required_inner_not_supported_exception;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;


@Service
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    @Override
    public User selectById(Long id) {
        return (User) jdbcTemplate.queryForObject("select * from lz_user where id = ? ",
                new Object[]{id}, new UserRowMapper());
    }

    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void updateById(User user) {
        jdbcTemplate.update("update lz_user set username = ? where id = ? ",
                new Object[]{user.getUsername(), user.getId()});
    }



    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public void updateUserNotSupportException123() {
        User user1 = selectById(456l);
        user1.setUsername("123quyixiao1xxxxx");
        updateById(user1);
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }



}
