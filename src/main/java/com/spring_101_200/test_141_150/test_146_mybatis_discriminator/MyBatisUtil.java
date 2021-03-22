package com.spring_101_200.test_141_150.test_146_mybatis_discriminator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {

    private final static SqlSessionFactory sqlSEssionFactory;

    static {
        String resource = "spring_101_200/config_141_150/spring146_mybatis_discriminator/mybatis-config.xml";
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
