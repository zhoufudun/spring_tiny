package com.spring_1_100.test_1_10.test2.cn21;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigTest {



    @Bean
    public HePerson he(){
        return new HePerson();
    }

}
