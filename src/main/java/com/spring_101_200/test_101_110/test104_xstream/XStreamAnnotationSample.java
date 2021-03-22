package com.spring_101_200.test_101_110.test104_xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Date;

public class XStreamAnnotationSample {

    private static XStream xStream;

    static {
        xStream = new XStream(new DomDriver());
        //实现该方法，判断要转换的类型
    }

    public static void main(String[] args) throws Exception {
        LzUser lzUser = new LzUser();
        lzUser.setUserId(1);
        lzUser.setUserName("zhangsan");
        lzUser.setPassword("123456");
        lzUser.setLastVisit(new Date());
        FileOutputStream outputStream = new FileOutputStream("/Users/quyixiao/project/spring_tiny/src/main/java/com/spring_101_200/test_101_110/test104_xstream/XStreamAnnotationSample.xml");
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, Charset.forName("utf-8"));
        xStream.toXML(lzUser, writer);


    }

}
