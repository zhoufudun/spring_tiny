package com.spring_101_200.test_181_190.test_190_spring_mvc_path_matching;

import javax.servlet.http.HttpServletRequest;

public class MyPathHelper  extends org.springframework.web.util.UrlPathHelper{


    @Override
    public String getPathWithinServletMapping(HttpServletRequest request) {
        System.out.println("=========MyPathHelper===============");
        return super.getPathWithinServletMapping(request);
    }



}
