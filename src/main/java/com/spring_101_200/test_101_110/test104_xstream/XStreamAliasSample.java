package com.spring_101_200.test_101_110.test104_xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XStreamAliasSample {

    private static XStream xStream;

    static {
        // 创建XStream实例并指定一个XML解析器
        xStream = new XStream(new DomDriver());
        // 设置类别名，默认为当前类名称加上包名
        xStream.alias("loginLog",LoginLog.class);
        xStream.alias("user",User.class);
        // 设置类成员别名
        xStream.aliasField("id",User.class,"userId");
        // 将LoginLog的UserId属性视为XML属性，默认的XML的元素
        xStream.aliasAttribute(LoginLog.class,"userId","id");
        xStream.useAttributeFor(LoginLog.class,"userId");
        // 去掉集合类型生成的XML的父节点，即忽略XML中的<logs></logs>标记
        xStream.addImplicitCollection(User.class,"logs");
    }


    // 初始化要转换的对象
    public static void objectToXML() throws Exception {
        // 获取转换的User对象实例
        User user = getUser();
        // 实例化一个文件输出流
        FileOutputStream outputStream = new FileOutputStream("/Users/quyixiao/project/spring_tiny/src/main/java/com/spring_101_200/test_101_110/test104_xstream/XStreamAliasSample.xml");
        // 将user对象转换成XML,并保存到指定的文件中
        xStream.toXML(user, outputStream);
    }


    public static User getUser() {
        User user = new User();
        user.setUserId(1l);
        user.setUsername("张三");
        LoginLog loginLog = new LoginLog();
        loginLog.setIp("172.0.0.1");
        loginLog.setLoginDate(new Date());


        LoginLog loginLog1 = new LoginLog();
        loginLog1.setIp("172.0.0.1");
        loginLog1.setLoginDate(new Date());



        List<LoginLog> loginLogs = new ArrayList<>();
        loginLogs.add(loginLog);
        loginLogs.add(loginLog1);
        user.setLogs(loginLogs);
        return user;
    }


    // 将XML转换成Java对象
    public static void XMLToObject() throws Exception {
        // 实例化一个文件输入流
        FileInputStream inputStream = new FileInputStream("/Users/quyixiao/project/spring_tiny/src/main/java/com/spring_101_200/test_101_110/test104_xstream/XStreamAliasSample.xml");
        User user = (User) xStream.fromXML(inputStream);
        for (LoginLog log : user.getLogs()) {
            System.out.println(log.getIp() + "----------" + log.getLoginDate());
        }
    }


    @Test
    public void test1() throws Exception {
        objectToXML();
    }


    @Test
    public void test2() throws Exception {
        XMLToObject();
    }
}