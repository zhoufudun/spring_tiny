package com.spring_101_200.test_131_140.test_136_mybatis_saferowboundsenabled;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class Test136 {


    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }


    @Test
    public void testGetUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<UserBillInfo> aa = sqlSession.selectList("com.spring_101_200.test_131_140.test_136_mybatis_saferowboundsenabled.UserMapper.selectUserBill",
                null, new RowBounds(0, 5));
        System.out.println(JSON.toJSONString(aa));
    }



    @Test
    public void test2() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserBillInfo userBillInfo = userMapper.selectUserBillResultType(456l);
        System.out.println(JSON.toJSONString(userBillInfo));
    }


    @Test
    public void test3() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserBillInfo userBillInfo = userMapper.selectUserBill(456l,new RowBounds(0,5));
        System.out.println(JSON.toJSONString(userBillInfo));
    }


    @Test
    public void test4() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserBillInfo> userBillInfos = userMapper.selectUserBills(456l,new RowBounds(0,5));
        System.out.println(JSON.toJSONString(userBillInfos));
    }



}
