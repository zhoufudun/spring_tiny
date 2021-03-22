package com.spring_1_100.test_71_80.test74_jdbc_tx_complex;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

public class UserServiceImpl implements UserService {
    private JdbcTemplate jdbcTemplate;


    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public User selectById(Long id) {
        return (User) jdbcTemplate.queryForObject("select * from lz_user where id = ? ",
                new Object[]{id}, new UserRowMapper());
    }

    @Override
    public void updateById(User user) {
        jdbcTemplate.update("update lz_user set username = ? where id = ? ",
                new Object[]{user.getUsername(), user.getId()});
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserRequiresNew1(){
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
       int i = 0 ;
        int j = 0;
        int c = i / j ;
    }




    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserRequiresNew2(){
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
    }




    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserRequiresNew33(){
        User user2 = selectById(456l);
        user2.setUsername("123");
        updateById(user2);
    }



    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserRequires1(){
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }




    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserRequires2(){
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserRequires(){
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateUserSupports(){
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateUserSupportsException(){
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void updateUserMandatory(){
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserRequire123() {
        User user1 = selectById(456l);
        user1.setUsername("123");
        updateById(user1);
    }


    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void updateUserNotSupportException() {
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
        int i = 0 ;
        int j = 0;
        int c = i / j ;
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



    @Transactional(propagation = Propagation.NEVER)
    @Override
    public void updateUserNever() {
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);



    }
    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void updateUserNested2() throws Exception{
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequireThrowException2() {
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }

    @Override
    public void updateUserRequireThrowException3() {
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
        int i = 0 ;
        int j = 0;
        int c = i / j ;

    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequireThrowException4() {
        try {
            User user2 = selectById(457l);
            user2.setUsername("456");
            updateById(user2);
            int i = 0 ;
            int j = 0;
            int c = i / j ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserRequired() {
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
    }


}
