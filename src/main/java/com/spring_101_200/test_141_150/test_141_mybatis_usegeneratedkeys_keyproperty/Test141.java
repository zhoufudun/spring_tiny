package com.spring_101_200.test_141_150.test_141_mybatis_usegeneratedkeys_keyproperty;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.parsing.TokenHandler;
import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class Test141 {


    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }



    @Test
    public void test() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setManagerId(1l);
        user.setPassword("123456");
        user.setRealName("哈哈");
        user.setUsername("zhangsan");
        userMapper.insertUser(user);
        sqlSession.commit();
        System.out.println(JSON.toJSONString(user));

    }




    @Test
    public void test1() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setManagerId(1l);
        user.setPassword("123456");
        user.setRealName("哈哈");
        user.setUsername("zhangsan");
        userMapper.insertUserIdAddDouble(user);
        sqlSession.commit();
        System.out.println(JSON.toJSONString(user));

    }



    @Test
    public void test2() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setManagerId(1l);
        user.setPassword("123456");
        user.setRealName("哈哈");
        user.setUsername("kwkkwkw");
        userMapper.insertUserNew(user);
        sqlSession.commit();
        System.out.println(JSON.toJSONString(user));
    }



    @Test
    public void test3() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(500l);
        user.setManagerId(1l);
        user.setPassword("123456");
        user.setRealName("你好");
        user.setUsername("kwkkwkw");
        userMapper.updateUser(user);
        sqlSession.commit();
        System.out.println(JSON.toJSONString(user));
    }



    @Test
    public void test4() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(500l);
        user.setManagerId(1l);
        user.setPassword("123456");
        user.setRealName("你好");
        user.setUsername("kwkkwkw");
        userMapper.updateUserById(user);
        sqlSession.commit();
        System.out.println(JSON.toJSONString(user));
    }

}
