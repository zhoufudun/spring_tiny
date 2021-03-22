package com.spring_101_200.test_151_160.test_153_mybatis_self_typehandler;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.executor.loader.ResultLoaderMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test153 {


    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }


    @Test
    public void testGetUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUser(456l);
        System.out.println(JSON.toJSONString(user));
    }


}
