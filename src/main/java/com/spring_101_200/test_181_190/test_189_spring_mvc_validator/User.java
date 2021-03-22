package com.spring_101_200.test_181_190.test_189_spring_mvc_validator;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull
    @Length(min = 5, max = 64)
    private String username;


    @NotNull
    @Length(min = 5, max = 64)
    private String password;


}
