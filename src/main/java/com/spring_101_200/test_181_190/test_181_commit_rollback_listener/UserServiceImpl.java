package com.spring_101_200.test_181_190.test_181_commit_rollback_listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;


@Service
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


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


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserRequiresNew1() {
        applicationEventPublisher.publishEvent(new MyTransactionEvent("我是和事务相关的事件，请事务提交后执行我~~~", 1));
        System.out.println(">>>>>>>>>>>>>>>>开始更新>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
        int i = 0 ;
        int j = 1;
        int k = j / i ;
    }


}
