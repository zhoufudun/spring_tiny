package com.spring_101_200.test_141_150.test_144_mybatis_cachenamespaceref;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class Test144 {


    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }

    @Test
    public void test() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUser(456l);
        sqlSession.commit();
        System.out.println("======================");
        user.setRealName("bbbbbbbb");

        User user2 = userMapper.getUser(456l);
        System.out.println(user2.getRealName());
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void test1() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserBillMapper userBillMapper = sqlSession.getMapper(UserBillMapper.class);
        User user = userMapper.getUser(456l);
        sqlSession.commit();
        System.out.println("======================");
        user.setRealName("bbbbbbbb");

        User user2 = userBillMapper.getUser(456l);
        System.out.println(user2.getRealName());
        System.out.println(JSON.toJSONString(user));
    }


}
