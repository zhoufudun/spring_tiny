package com.spring_101_200.test_151_160.test_152_ognl;

import ognl.Ognl;
import ognl.OgnlContext;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.scripting.xmltags.OgnlCache;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/***
 * ognl 表达式博客 ： https://www.cnblogs.com/cenyu/p/6233942.html
 */
public class Test152 {

    @Test
    public void test(){
        User user  = new User();
        user.setUsername("zhangsan");
        Object value = OgnlCache.getValue("username !=null ", user);
        System.out.println(value);
    }


    @Test
    public void test1() throws Exception {
        User root = new User();
        root.setUsername("1234");
        OgnlContext context = new OgnlContext();
        context.setRoot(root);
        Object password = Ognl.getValue("username != null ", context, root);
        System.out.println(password);
    }

    @Test
    public void test2() throws Exception {
        //1 获取context
        OgnlContext context = new OgnlContext();
        //2 获取根对象
        Object root = context.getRoot();
        // 3 执行表达式
        Object object = Ognl.getValue("'i am grece'.length()", context, root);
        System.out.println(object);
    }


    @Test
    public void test3() throws Exception {
        //1 获取context
        OgnlContext context = new OgnlContext();
        //2 获取根对象
        Object root = context.getRoot();
        // 3 执行表达式
        Object object = Ognl.getValue("@java.lang.Math@random()", context, root);
        System.out.println(object);
    }

    @Test
    public void test4() throws Exception {
        User root = new User();
        root.setPassword("1234");
        OgnlContext context = new OgnlContext();
        context.setRoot(root);
        Object password = Ognl.getValue("password", context, root);
        System.out.println(password);
    }

    @Test
    public void test5() throws Exception {
        OgnlContext context = new OgnlContext();
        context.put("name", "张三");
        Object password = Ognl.getValue("#name", context, context.getRoot());
        System.out.println(password);
    }


    @Test
    public void test6() throws Exception {
//创建一个Ognl上下文对象
        OgnlContext context = new OgnlContext();
        /**
         * 1.OgnlContext放入基本变量数据
         */
        //放入数据
        context.put("cn", "China");
        //获取数据（map）
        String value = (String) context.get("cn");

        System.out.println(value);

    }


    @Test
    public void test7() throws Exception {

        OgnlContext context = new OgnlContext();
        /**
         * 2.OgnlContext放入对象数据
         */
        //创建对象，设置对象属性
        User user = new User();
        user.setId(100);
        user.setName("Jack");
        //【往非根元素放入数据，取值的时候表达式要用“#”】
        context.put("user", user);
        //获取对象属性
        //使用这种方式也可以获取
        Object s = context.get("user");
        System.out.println(s);
    }


    @Test
    public void test8() throws Exception {
        OgnlContext context = new OgnlContext();
        User user = new User();
        user.setId(100);
        user.setName("Jack");
        //【往非根元素放入数据，取值的时候表达式要用“#”】
        context.put("user", user);
        //使用Ognl表达式来获取
        //举例：例如标签<s:a value="#user.id">取值，实际上就是运行了下面的代码获取的
        //先构建一个Ognl表达式，再解析表达式
        Object ognl = Ognl.parseExpression("#user.id");//构建Ognl表达式
        Object value1 = Ognl.getValue(ognl, context, context.getRoot());//解析表达式
        System.out.println(value1);

    }


    //非根元素
    @Test
    public void testOgnl1() throws Exception {
        OgnlContext context = new OgnlContext();

        User user1 = new User();
        user1.setId(100);
        user1.setName("Jack");
        context.setRoot(user1);
        Object ognl1 = Ognl.parseExpression("id");//构建Ognl表达式
        Object value2 = Ognl.getValue(ognl1, context, context.getRoot());//解析表达式
        System.out.println(value2);

    }


    //根元素，
    @Test
    public void testOgnl2() throws Exception {
        OgnlContext context = new OgnlContext();

        User user1 = new User();
        user1.setId(100);
        user1.setName("Jack");
        context.setRoot(user1);
        //根元素直接使用id,不需要加#号
        Object ognl1 = Ognl.parseExpression("id");//构建Ognl表达式
        Object value2 = Ognl.getValue(ognl1, context, context.getRoot());//解析表达式
        System.out.println(value2);

    }


    @Test
    public void testOgnl3() throws Exception {
        //创建一个Ognl上下文对象
        OgnlContext context = new OgnlContext();

        //Ognl表达式语言，调用类的静态方法
//        Object ognl = Ognl.parseExpression("@Math@floor(10.9)");
        //由于Math类在开发中比较常用，所有也可以这样写
        Object ognl = Ognl.parseExpression("@@floor(10.9)");
        Object value = Ognl.getValue(ognl, context, context.getRoot());
        System.out.println(value);
    }



}
