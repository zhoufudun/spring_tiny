package com.spring_101_200.test_121_130.test_125_mybatis_properties;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

import java.util.*;

public class Test125 {


    static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSEssionFactory();
    }


    @Test
    public void testGetUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);




        User user = userMapper.getUser(456l);

        user.setUsername("zhangsan");

        userMapper.updateById(user);

        user = userMapper.getUser(456l);


        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void test3() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = userMapper.getUserList(456l);
        System.out.println(JSON.toJSONString(user));
    }


    @Test
    public void test4() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map user = userMapper.getUserByMap(456l);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void test2() throws Exception {
        SqlSession sqlSession = MyBatisUtil1.getSqlSEssionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUser(456l);
        System.out.println(JSON.toJSONString(user));
    }


    @Test
    public void test5() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        MyDefaultResultSetHandler myDefaultResultSetHandler = new MyDefaultResultSetHandler();
        userMapper.getUserByResultHandler(456l, myDefaultResultSetHandler);
        System.out.println(JSON.toJSONString(myDefaultResultSetHandler.getResultMap()));
    }


    @Test
    public void test6() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(456l);
        User userB = userMapper.getUserByUser(user);
        System.out.println(JSON.toJSONString(userB));
    }


    @Test
    public void test8() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserInfo userB = userMapper.findUserById(456l);
        System.out.println(JSON.toJSONString(userB));
    }

    @Test
    public void test9() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserInfo userB = userMapper.findUserCompexById(456l);
        System.out.println(JSON.toJSONString(userB));
    }


    @Test
    public void test10() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserBill userB = userMapper.findUserBillLazyLoading(60l);
        System.out.println(JSON.toJSONString(userB));
    }


    public static SqlSessionFactory getSqlSessionFactory() {
        //构建数据库连接池
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pple_test?characterEncoding=utf-8");
        dataSource.setUsername("ldd_biz");
        dataSource.setPassword("Hello1234");
        //构建数据库事务处理方式
        TransactionFactory txFactory = new JdbcTransactionFactory();
        //创建数据库运行环境
        Environment environment = new Environment("development", txFactory, dataSource);
        //构建Configuration 对象
        Configuration configuration = new Configuration(environment);
        //注册一个 MyBatis上下文别名
        configuration.getTypeAliasRegistry().registerAlias("User", User.class);
        //加入一个映射器
        configuration.addMapper(UserMapper.class);
        //使用 SqlSessionFactoryBuilder 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

    @Test
    public void test1() {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("=================================");
        User user = userMapper.getUser(456l);
        System.out.println(JSON.toJSONString(user));
    }

    public static SqlSessionFactory getSqlSessionFactoryNew() {
        TransactionFactory txFactory = new JdbcTransactionFactory();
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pple_test?characterEncoding=utf-8");
        dataSource.setUsername("ldd_biz");
        dataSource.setPassword("Hello1234");
        Environment.Builder environmentBuilder = new Environment.Builder("development")
                .transactionFactory(txFactory)
                .dataSource(dataSource);
        //构建Configuration 对象
        Configuration configuration = new Configuration();
        configuration.setEnvironment(environmentBuilder.build());
        //注册一个 MyBatis上下文别名
        configuration.getTypeAliasRegistry().registerAlias("User", User.class);
        //加入一个映射器
        configuration.addMapper(UserMapper.class);
        //使用 SqlSessionFactoryBuilder 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }


    @Test
    public void test7() {
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        Collection collection = defaultObjectFactory.create(Collection.class);
        System.out.println(collection);
        Set set = defaultObjectFactory.create(Set.class);
        System.out.println(set);

        Long b = defaultObjectFactory.create(Long.class);

    }


    @Test
    public void test11() {
        String columnName = "{id=user_id}";
        StringTokenizer parser = new StringTokenizer(columnName, "{}=, ", false);
        while (parser.hasMoreTokens()) {
            //获取属性
            String property = parser.nextToken();
            //获取列
            String column = parser.nextToken();
            System.out.println("property="+property + ",column="+column);

        }
    }




    @Test
    public void test12() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserBill userB = userMapper.selectBillInfo(60l,456l);
        System.out.println(JSON.toJSONString(userB));
    }

}
