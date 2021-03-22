package com.spring_1_100.test_81_90.test81_import_source;

import lombok.Data;

@Data
public class LogonService {
    private LogDao logDao;

    private UserDao userDao;
}