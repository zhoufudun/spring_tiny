package com.spring_1_100.test_81_90.test84_property_placeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyDataSource {


    @Value("${url}")
    private String url;
    @Value("${redisUrl}")
    private String redisUrl;

    @Value("#{sysConfig.sessionTimeout}")
    private int sessionTimeout;

    @Override
    public String toString() {
        return "MyDataSource{" +
                "url='" + url + '\'' +
                ", redisUrl='" + redisUrl + '\'' +
                ", sessionTimeout=" + sessionTimeout +
                '}';
    }
}
