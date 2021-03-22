package com.spring_1_100.test_81_90.test81_import_source;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:spring_1_100/config_81_90/spring81_import_resource.xml")
public class LogonAppConfig {


    @Bean
    @Autowired
    public LogonService logonService(UserDao userDao,LogDao logDao){
        LogonService logonService = new LogonService();
        logonService.setUserDao(userDao);
        logonService.setLogDao(logDao);
        return logonService;
    }


}
