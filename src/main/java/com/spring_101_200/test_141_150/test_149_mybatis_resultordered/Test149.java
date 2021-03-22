package com.spring_101_200.test_141_150.test_149_mybatis_resultordered;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Test149 {


    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }


    @Test
    public void testGetUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = userMapper.getUser(456l);
        Iterator<User> iterator1 = user.iterator();
        System.out.println("===========开始打印===============");
        while (iterator1.hasNext()) {
            User next = iterator1.next();
            System.out.println("=====打印User===="+next);
        }
    }

    public String getColumnPrefix(String parentPrefix, String columnPrefixOld) {
        final StringBuilder columnPrefixBuilder = new StringBuilder();
        if (parentPrefix != null) columnPrefixBuilder.append(parentPrefix);
        if (columnPrefixOld!= null) columnPrefixBuilder.append(columnPrefixOld);
        final String columnPrefix = columnPrefixBuilder.length() == 0 ? null : columnPrefixBuilder.toString().toUpperCase(Locale.ENGLISH);
        return columnPrefix;
    }


    @Test
    public void test3(){
        System.out.println(getColumnPrefix("a_","b"));
        System.out.println(getColumnPrefix("","b"));

    }
}
