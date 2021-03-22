package com.spring_101_200.test_101_110.test104_xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectStreamSample {

    private static XStream xStream;

    static {
        // 创建XStream实例并指定一个XML解析器
        xStream = new XStream(new DomDriver());

    }


    // 初始化要转换的对象
    public static void objectToXML() throws Exception {
        // 获取转换的User对象实例
        User user = getUser();
        // 创建一个PrintWriter用于输出
        PrintWriter pw = new PrintWriter("/Users/quyixiao/project/spring_tiny/src/main/java/com/spring_101_200/test_101_110/test104_xstream/ObjectStreamSample.xml");
        // 先用一个HierarchicalStreamWriter的实现类来创建输出
        PrettyPrintWriter ppw = new PrettyPrintWriter(pw);
        // 创建对象输出流
        ObjectOutputStream out = xStream.createObjectOutputStream(ppw);
        out.writeObject(user);
        out.close();

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
        FileReader inputStream = new FileReader("/Users/quyixiao/project/spring_tiny/src/main/java/com/spring_101_200/test_101_110/test104_xstream/ObjectStreamSample.xml");
        BufferedReader bufferedReader = new BufferedReader(inputStream);
        ObjectInputStream input = xStream.createObjectInputStream(bufferedReader);
        User user = (User)input.readObject();
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