package com.spring_101_200.test_131_140.test_139_mybatis_saferesulthandlerenabled;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class Test139 {


    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }

    @Test
    public void testGetUser1() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.select("com.spring_101_200.test_131_140.test_139_mybatis_saferesulthandlerenabled.UserMapper.selectUserBill", new MyDefaultResultSetHandler());
    }


}
