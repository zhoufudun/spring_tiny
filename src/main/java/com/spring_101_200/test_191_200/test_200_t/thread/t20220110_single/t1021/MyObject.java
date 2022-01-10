package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1021;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyObject {

    // 本章使用若干安全来阐述童便模式与多线程结合时遇到的情况与解决方法，本章也复习了不同的童便模式的使用，使得以后再遇到单例模式时，能
    // 从容面对多线程环境的情况了
    public enum MyEnumSingleton {
        connectFactory;
        private Connection connection;

        private MyEnumSingleton() {
            try {
                System.out.println("创建MyObject对象");
                String url = "jdbc:sqlserver://localhost:1079;databaseName=y2";
                String username = "sa";
                String password = "";
                String driveName = "com.misorosoft.sqlserver.jdbc.SQLServerDriver";
                Class.forName(driveName);
                connection = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public Connection getConnection() {
            return connection;
        }
    }

    public static Connection getConnection() {
        return MyEnumSingleton.connectFactory.getConnection();
    }


}
