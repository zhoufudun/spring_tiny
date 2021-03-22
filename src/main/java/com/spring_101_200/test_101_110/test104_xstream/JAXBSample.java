package com.spring_101_200.test_101_110.test104_xstream;

import org.junit.Test;
import org.springframework.dao.ConcurrencyFailureException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class JAXBSample {
    /**
     * XMLBeans 是完全与模式兼容的XML-java 绑定工具，提供了一种友好的方式来访问XML的全部特性，XMLBeans解决方案是独一无二的，因为
     * 它提供了XML数据的双重视图，XMLStream 维护了一个信息也结构均未更改的原始XML,并提供了一相基于Java 的XML 数据视图，目前最新的版本是
     * 2009
     * 通过XMLBeans提供的命令工具scomp 编译schema(.xsd) 产生不同的java类，并自动的把java 类和XML 文档进行绑定，这个，XMLBeans 就会生成
     * 访问XML该票不相应的jav类，并打成java 包，通过这个jar包中的类，你可以对XML进行各种操作，如读取XML文档的对象，如果采用传统的方法
     * 操作XML是一件烦琐的事情，XMLBeans给我们带来便利的远不止这些，假设我们自己来实现一个关于XML操作的功能，有一天需求发生变化就不得不
     * 重新修改原来的那些烦琐的程序，而我们用了XMLBeans ，碰到这些情况就会轻松许多，我们只需要重新编译一个修改好的schema,重新生成一个新的操作
     * 包就可以了，XMLBeans的主要的特点就是。
     * 内存占用低，DOM 在内容中生成的整个XML的树，如果文档的非常大，DOM就会变得对内存非常的敏感，并会显著的降低性能，XMLBeans 通过增量解
     * 组提供的xget方法来访问内置的模式数据类型，使得XMLBeans取得较好的性能，
     * 简洁易用：与DOM相比，SAX对内存的要求不高，但是SAX要求开发 人员为事件处理程序编写回调方法，而XMLBeans则不需要。
     * 模式支持丰富，XMLBeans 几乎百分之百的支持XML Schema  ，此外，XMLBeans还能够访问完整的XML Infoset ，对于强调元素的顺序或者注解
     * 的应用程序，这一点特别有用
     * 即时验证： XMLBeans 提供了一些XML文档即时验证。
     * 高级特性，XML
     *
     */

    public static void objectToXML() throws Exception{
        User user = XStreamAliasSample.getUser();
        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        FileWriter writer = new FileWriter("/Users/quyixiao/project/spring_tiny/src/main/java/com/spring_101_200/test_101_110/test104_xstream/JAXBSample.xml");
        m.marshal(user,writer);
    }

    // 将XML转换成Java对象
    public static void XMLToObject() throws Exception {
        JAXBContext context = JAXBContext.newInstance(User.class);
        FileReader reader = new FileReader("/Users/quyixiao/project/spring_tiny/src/main/java/com/spring_101_200/test_101_110/test104_xstream/JAXBSample.xml");
        Unmarshaller um =context.createUnmarshaller();
        User user = (User)um.unmarshal(reader);
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
