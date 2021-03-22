package com.spring_101_200.test_141_150.test_145_mybatis_cachenamespaceref_xml;

import com.alibaba.fastjson.JSON;
import com.sun.jdi.PathSearchingVirtualMachine;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.type.JdbcType;

import javax.print.attribute.standard.MediaSize;
import java.util.Iterator;

public class MyPropertyTokenizer {
    private String name;
    private String indexedName;
    private String index;
    private String children;

    public static void main(String[] args) {
        MyPropertyTokenizer myPropertyTokenizer = new MyPropertyTokenizer("factory.user.id");

        System.out.println(JSON.toJSONString(myPropertyTokenizer));

        System.out.println(JdbcType.CURSOR.name());
    }

    public MyPropertyTokenizer(String fullname) {
        int delim = fullname.indexOf('.');
        if (delim > -1) {
            name = fullname.substring(0, delim);
            children = fullname.substring(delim + 1);
        } else {
            name = fullname;
            children = null;
        }
        indexedName = name;
        delim = name.indexOf('[');
        if (delim > -1) {
            index = name.substring(delim + 1, name.length() - 1);
            name = name.substring(0, delim);
        }
    }

    public String getName() {
        return name;
    }

    public String getIndex() {
        return index;
    }

    public String getIndexedName() {
        return indexedName;
    }

    public String getChildren() {
        return children;
    }

    public boolean hasNext() {
        return children != null;
    }

    public PropertyTokenizer next() {
        return new PropertyTokenizer(children);
    }

    public void remove() {
        throw new UnsupportedOperationException("Remove is not supported, as it has no meaning in the context of properties.");
    }


}