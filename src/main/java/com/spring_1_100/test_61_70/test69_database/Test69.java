package com.spring_1_100.test_61_70.test69_database;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Test69 {

    @Test
    public void testQuery() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring69.xml");
        UserService userService = (UserService) ac.getBean("userService");
        List<User> users = userService.getUsersByName("19884189046");
        System.out.println(JSON.toJSONString(users));
    }


    @Test
    public void springUpdate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring69.xml");
        UserService userService = (UserService) ac.getBean("userService");
        User user = new User();
        user.setUsername("19884189046");
        user.setPassword("654321");
        int a = userService.update(user);
        System.out.println(a);
    }


    @Test
    public void springQueryForObject() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring69.xml");
        UserService userService = (UserService) ac.getBean("userService");
        User user = userService.queryForObject("19884189046");
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void jdbcQuery() {
        Connection conn = null;
        PreparedStatement pstemt = null;
        try {
            //注册加载jdbc驱动
            Class.forName("com.mysql.jdbc.Driver");
            //打开连接
            conn = DriverManager.getConnection("jdbc:mysql://172.16.157.238:3306/lt_biz?characterEncoding=utf-8", "ldd_biz", "Hello1234");
            //创建执行对象
            String sql = "SELECT bb.id as billIds, ub.id as cardId,up.user_name_en as userName,sb.supplier_code as supplierCode, (bb.bill_amount + bb.overdue_amount + bb.differ_amount - bb.credit_capital - bb.sum_capital - bb.credit_rate - bb.sum_rate - bb.credit_premium - bb.sum_premium) as repaymentAmount, bb.bill_nper billNper,sb.id borrowId \n" +
                    "from lt_borrow_bill bb LEFT JOIN lt_stage_borrow sb ON sb.id = bb.borrow_id \n" +
                    "LEFT JOIN lt_user_bankcard ub on bb.unique_code = ub.unique_code\n" +
                    "LEFT JOIN lt_user_phone up on bb.unique_code = up.unique_code where sb.supplier_code='100000280' \n" +
                    "and ub.is_delete = 0 and up.is_delete = 0 and bb.is_delete=0 and ub.pay_channel = 4 and up.is_main = 1 and ub.is_main = 1 and ub.status = 1 and bb.`status`=0 and sb.status =5 and date(bb.gmt_plan_repayment) <= date(now()) AND up.user_name_en IN ( ? ) order by bb.bill_nper,bb.id ";
            pstemt = conn.prepareStatement(sql);
            pstemt.setObject(1,"ZkE9XwMx+pxUyFSC+wjwbw==");
            //执行sql语句
            ResultSet rs = pstemt.executeQuery();
            System.out.println("---------");
            //展开结果集
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    @Test
    public void jdbcUpdate() {
        Connection conn = null;
        PreparedStatement pstemt = null;
        try {
            //注册加载jdbc驱动
            Class.forName("com.mysql.jdbc.Driver");
            //打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pple_test?characterEncoding=utf-8", "ldd_biz", "Hello1234");
            //创建执行对象
            String sql = "update lz_user set password = ? where username = ? ";
            pstemt = conn.prepareStatement(sql);
            pstemt.setString(1, "123456");
            pstemt.setString(2, "19884189046");
            //执行sql语句
            int num = pstemt.executeUpdate();
            System.out.println(num);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void jdbcInsert() {
        Connection conn = null;
        PreparedStatement pstemt = null;
        try {
            //注册加载jdbc驱动
            Class.forName("com.mysql.jdbc.Driver");
            //打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pple_test?characterEncoding=utf-8", "ldd_biz", "Hello1234");
            //创建执行对象
            String sql = " INSERT INTO lz_user (username, password, real_name, manager_id )" +
                    " VALUES " +
                    " ( ?, ?, ?, ?)";
            pstemt = conn.prepareStatement(sql, com.mysql.jdbc.Statement.RETURN_GENERATED_KEYS);
            pstemt.setString(1, "18389328");
            pstemt.setString(2, "123456");
            pstemt.setString(3, "张三");
            pstemt.setString(4, "1");
            //执行sql语句
            int num = pstemt.executeUpdate();
            System.out.println(num);

            ResultSet rs = pstemt.getGeneratedKeys();
            while (rs.next()){
                System.out.println("============" + rs.getLong(1));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
