package com.spring_1_100.test_71_80.test80_configuration;

import lombok.Data;

@Data
public class LogonService {
    private LogDao logDao;

    private UserDao userDao;
}