package com.spring_101_200.test_101_110.test105_conversion_string_to_user;


import com.utils.NumberUtil;
import com.utils.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class StringToUserConverter implements Converter<String, User> {
    @Override
    public User convert(String source) {
        User user = new User();
        if (StringUtils.isNotBlank(source)) {
            String s [] = source.split(":");
            user.setUserName(s[0]);
            user.setPassword(s[1]);
            user.setAge(NumberUtil.objToIntDefault(s[2],0));
        }
        return user;
    }

}
