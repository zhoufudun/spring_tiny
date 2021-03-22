package com.spring_101_200.test_121_130.test_125_mybatis_properties;

import javafx.beans.property.Property;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class MyBatisUtil1 {

    private final static SqlSessionFactory sqlSEssionFactory ;

    static {
        String resource = "spring_101_200/config_121_130/spring125_mybatis_properties/mybatis-config.xml";
        InputStream cfgStream = null;
        Reader cfgReader = null;
        InputStream proStream = null;
        Reader proReader = null;
        Properties properties = null;
        try {
            //读取配置文件流
            cfgStream = Resources.getResourceAsStream(resource);
            cfgReader = new InputStreamReader(cfgStream);
            //读取属性文件
            proStream = Resources.getResourceAsStream("spring_101_200/config_121_130/spring125_mybatis_properties/db.properties");
            proReader = new InputStreamReader(proStream);
            properties = new Properties();
            properties.load(proReader);
            //解密为明文
            properties.setProperty("username",decode(properties.getProperty("db.username")));
            properties.setProperty("password",decode(properties.getProperty("db.pwd")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSEssionFactory = new SqlSessionFactoryBuilder().build(cfgReader,properties);
    }

    public static String decode(String value){
        return value;
    }

    public static SqlSessionFactory getSqlSEssionFactory(){
        return sqlSEssionFactory;
    }


}
