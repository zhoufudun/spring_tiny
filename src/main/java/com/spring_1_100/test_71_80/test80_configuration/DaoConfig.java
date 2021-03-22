package com.spring_1_100.test_71_80.test80_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig.class)
public class DaoConfig {
    @Autowired
    private AppConfig appConfig;

    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();
        logonService.setLogDao(appConfig.logDao());
        logonService.setUserDao(appConfig.userDao());
        return logonService;
    }


}
