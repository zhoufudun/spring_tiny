package com.spring_1_100.test_61_70.test69_database;

import java.util.List;

public interface UserService {

    void save(User user);


    int update(User user);

    List<User> getUsers();
    List<User> getAllUsersByName(String username) ;


    User queryForObject(String username);

    List<User> getUsersByName(String username);

     List<String> queryObjectUsersByName(String username);
}