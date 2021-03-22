package com.spring_101_200.test_191_200.test_195_spring_mvc_message_codes_resolver;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class User {
    private String username;


    private String password;

    private String mobile;



}
