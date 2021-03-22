package com.spring_101_200.test_131_140.test_135_mybatis_executor;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class Test135 {


    //https://blog.csdn.net/weixin_34267123/article/details/92407774
    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }

    @Test
    public void test1() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(456l);
        user = userMapper.findUserById(456l);
        System.out.println(JSON.toJSONString(user));
    }


    @Test
    public void test2() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateRealName(456l,"zhangsan",1);
        userMapper.updateRealName(457l,"lisi",1);
    }



    @Test
    public void test3() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateRealName(456l,"zhangsan",1);
        userMapper.update(458l);
        userMapper.updateRealName(457l,"lisi",1);
    }



}
