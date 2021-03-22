package com.spring_101_200.test_131_140.test_134_mybatis_usecolumnlabel;

import com.alibaba.fastjson.JSON;
import com.spring_101_200.test_131_140.test_133_mybatis_lazyloadingenabled_aggressivelazyloading.UserBill;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class Test134 {


    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }


    @Test
    public void findUserBillLazyLoading() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(456l);
        System.out.println(JSON.toJSONString(user));
    }


}
