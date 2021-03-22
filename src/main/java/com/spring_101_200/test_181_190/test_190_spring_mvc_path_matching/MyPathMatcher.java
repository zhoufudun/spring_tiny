package com.spring_101_200.test_181_190.test_190_spring_mvc_path_matching;

import org.springframework.util.AntPathMatcher;

public class MyPathMatcher extends AntPathMatcher {


    public boolean match(String pattern, String path) {
        System.out.println("==================do match =======================");
        return super.match(pattern,path);
    }




}
