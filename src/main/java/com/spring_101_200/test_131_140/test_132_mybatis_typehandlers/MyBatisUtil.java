package com.spring_101_200.test_131_140.test_132_mybatis_typehandlers;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

//https://www.cnblogs.com/zhai1997/p/12530641.html
public class MyBatisUtil {

    private final static SqlSessionFactory sqlSEssionFactory;

    static {
        String resource = "spring_101_200/config_131_140/spring132_mybatis_typehandlers/mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSEssionFactory = new SqlSessionFactoryBuilder().build(reader);

    }

    public static SqlSessionFactory getSqlSEssionFactory(){
        return sqlSEssionFactory;
    }


}
