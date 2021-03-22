package com.spring_101_200.test_101_110.test104_xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class XStreamJSONSample {

    private static XStream xstream ;


    static {
        // 创建XStream实例并指定一个XML解析器
         xstream = new XStream(new DomDriver());

    }


    // 初始化要转换的对象
    public static void objectToXML() throws Exception {
        // 获取转换的User对象实例
        User user = XStreamAliasSample.getUser();
        // 实例化一个文件输出流
        FileOutputStream outputStream = new FileOutputStream("/Users/quyixiao/project/spring_tiny/src/main/java/com/spring_101_200/test_101_110/test104_xstream/XStreamJSONSample1.json");
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
        xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("user",User.class);
        xstream.toXML(user,writer);
    }


    public static void toJsonByJsonHierarchicalStreamDriver() throws Exception{
        // 获取转换的User对象实例
        User user = XStreamAliasSample.getUser();
        // 实例化一个文件输出流
        FileOutputStream outputStream = new FileOutputStream("/Users/quyixiao/project/spring_tiny/src/main/java/com/spring_101_200/test_101_110/test104_xstream/XStreamJSONSample2.json");
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
        xstream = new XStream(new JsonHierarchicalStreamDriver());
        xstream.alias("user",User.class);
        xstream.toXML(user,writer);
    }

    @Test
    public void test1() throws Exception {
        objectToXML();
    }


    @Test
    public void test2() throws Exception {
        toJsonByJsonHierarchicalStreamDriver();
    }



}
