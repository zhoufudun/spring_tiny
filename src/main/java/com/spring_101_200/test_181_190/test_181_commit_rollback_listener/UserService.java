package com.spring_101_200.test_181_190.test_181_commit_rollback_listener;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);

    void updateUserRequiresNew1();

}