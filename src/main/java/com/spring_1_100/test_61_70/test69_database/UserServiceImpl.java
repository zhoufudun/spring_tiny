package com.spring_1_100.test_61_70.test69_database;

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
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO lz_user (username, password, real_name, manager_id) VALUES ( ?, ?, ?, ?) ",
                new Object[]{user.getUsername(), user.getPassword(), user.getRealName(), user.getManagerId()});

    }

    @Override
    public int update(User user) {
        int num = jdbcTemplate.update("update lz_user set password = ? where username = ?  ",
                new Object[]{user.getPassword(),user.getUsername()});
        return num;
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


    public List<User> getAllUsersByName(String username) {
        return  jdbcTemplate.query("select * from lz_user ",new UserRowMapper());

    }


    public User queryForObject(String username) {
        Integer a =   jdbcTemplate.queryForObject("select count(*) from lz_user limit 1  ",Integer.class);
        System.out.println(a );
        return null;
    }


    @Override
    public List<String> queryObjectUsersByName(String username) {
        List<String> list =  jdbcTemplate.queryForList("select password from lz_user where username = '" + username + "'",
             String.class);
        return list;
    }
}
