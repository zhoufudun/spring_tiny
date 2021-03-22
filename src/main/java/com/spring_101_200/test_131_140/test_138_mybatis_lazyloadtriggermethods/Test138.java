package com.spring_101_200.test_131_140.test_138_mybatis_lazyloadtriggermethods;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class Test138 {


    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }


    @Test
    public void findUserBillLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(456l);
        System.out.println("-------------equals方法执行---------");
        System.out.println("equals result  : " + user.equals(new User()));
        System.out.println("-------------hashCode方法执行---------");
        System.out.println("hashCode: " + user.hashCode());
    }

}
