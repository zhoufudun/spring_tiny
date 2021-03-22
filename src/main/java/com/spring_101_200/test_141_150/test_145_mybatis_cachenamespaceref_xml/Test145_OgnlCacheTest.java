package com.spring_101_200.test_141_150.test_145_mybatis_cachenamespaceref_xml;

import org.apache.ibatis.scripting.xmltags.OgnlCache;

public class Test145_OgnlCacheTest {

    public static void main(String[] args) {
        User user = new User();
        user.setPassword("1234");
        Object value = OgnlCache.getValue("password == 3", user);
        System.out.println(value);
    }
}
