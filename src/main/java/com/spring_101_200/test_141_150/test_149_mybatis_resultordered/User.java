package com.spring_101_200.test_141_150.test_149_mybatis_resultordered;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Integer id;
    private String name;
    private List<String> groups;
    private List<String> roles;

}