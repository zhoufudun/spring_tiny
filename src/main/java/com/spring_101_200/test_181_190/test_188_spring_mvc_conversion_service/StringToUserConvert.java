package com.spring_101_200.test_181_190.test_188_spring_mvc_conversion_service;

import com.utils.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class StringToUserConvert implements Converter<String, User> {


    @Override
    public User convert(String source) {
        User user = new User();
        if (StringUtils.isNotBlank(source)) {
            String[] split = source.split(":");
            user.setUsername(split[0]);
            user.setPassword(split[1]);
        }
        return user;
    }
}
