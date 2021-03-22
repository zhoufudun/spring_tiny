package com.spring_101_200.test_121_130.test_130_mybatis_automappingbehavior;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class Test130 {


    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }


    @Test
    public void testGetUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserBillInfo userBillInfo = userMapper.selectUserBill(456l);
        System.out.println(JSON.toJSONString(userBillInfo));

    }
}
