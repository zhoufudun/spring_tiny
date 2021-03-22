package com.spring_1_100.test_71_80.test73_jdbc_transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;




@Transactional(propagation = Propagation.REQUIRED)
public interface UserService {

    void save(User user) throws Exception;


    List<User> getUsers();



    List<User> getUsersByName(String username);

     List<User> queryObjectUsersByName(String username);
}