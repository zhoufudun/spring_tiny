package com.spring_1_100.test_71_80.test73_jdbc_transaction;

import com.alibaba.fastjson.JSON;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserServiceImpl implements UserService {
    private JdbcTemplate jdbcTemplate;


    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) throws Exception {
        jdbcTemplate.update("INSERT INTO lz_user (username, password, real_name, manager_id) VALUES ( ?, ?, ?, ?) ",
                new Object[]{user.getUsername(), user.getPassword(), user.getRealName(), user.getManagerId()});

        throw  new RuntimeException("bbbbbbbbbbbbb");
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("select * from lz_user ", new UserRowMapper());
    }

    @Override
    public List<User> getUsersByName(String username) {
        return  jdbcTemplate.query("select * from lz_user where username = ? ",
                new Object[]{username},new UserRowMapper());
    }


    @Override
    public List<User> queryObjectUsersByName(String username) {
        List<String> list =  jdbcTemplate.queryForList("select password from lz_user where username = '" + username + "'",
             String.class);

        System.out.println(JSON.toJSONString(list));

        return null;
    }
}
