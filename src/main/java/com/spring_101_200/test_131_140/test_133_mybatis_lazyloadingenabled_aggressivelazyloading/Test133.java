package com.spring_101_200.test_131_140.test_133_mybatis_lazyloadingenabled_aggressivelazyloading;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class Test133 {


    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }


    @Test
    public void findUserBillLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserBill userBill = userMapper.findUserBillLazyLoading(60l);

        System.out.println("----------------------");
        System.out.println("realName:" + userBill.getUser().getRealName());
        System.out.println("----------------------");
        System.out.println("billList:" + userBill.getUser().getBillList());
    }


    @Test
    public void findUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(456l);
        System.out.println("----------------------");
        System.out.println(user.getBillList());
    }




    @Test
    public void test3() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserBill userBill = userMapper.findUserBillLazyLoading(60l);
        System.out.println(JSON.toJSONString(userBill));
    }
}
