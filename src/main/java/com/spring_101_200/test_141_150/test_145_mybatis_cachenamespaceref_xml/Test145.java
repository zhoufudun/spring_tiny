package com.spring_101_200.test_141_150.test_145_mybatis_cachenamespaceref_xml;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test145 {


    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }


    @Test
    public void test1() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserBillMapper userBillMapper = sqlSession.getMapper(UserBillMapper.class);
        System.out.println("首次通过userMapper查询用户信息：");
        User user = userMapper.getUser(456l);
        System.out.println("user:" + JSON.toJSONString(user));
        sqlSession.commit();
        System.out.println("第二次通过userMapper查询用户信息：");
        user = userMapper.getUser(456l);
        System.out.println("第三次通过userBillMapper查询用户信息：");
        User user2 = userBillMapper.getUser(456l);
        System.out.println("user2:" + JSON.toJSONString(user2));
    }


    @Test
    public void test2() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


        User param = new User();
        param.setPassword("123456aaaaa");
        User user = userMapper.getUserByParameterMap(param);
        System.out.println(JSON.toJSONString(user));

    }




    @Test
    public void testCompx() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User > user = userMapper.getUserByCompx(456l, Arrays.asList("zhangsan","lisi"),0);
        System.out.println(JSON.toJSONString(user));

    }



}
