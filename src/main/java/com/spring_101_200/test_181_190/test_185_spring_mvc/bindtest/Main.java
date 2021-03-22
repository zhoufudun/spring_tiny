package com.spring_101_200.test_181_190.test_185_spring_mvc.bindtest;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;

import java.lang.reflect.Array;

//https://blog.csdn.net/qq_41907991/article/details/105333258
public class Main {
    private Person person = new Person();
    private DataBinder binder = new DataBinder(person, "person");
    private MutablePropertyValues pvs = new MutablePropertyValues();

    @Test
    public void test0() {    //{"age":18}
        pvs.add("age", 18);
        binder.bind(pvs);
        System.out.println(JSON.toJSONString(person));
    }

    @Test
    public void test() {        //{"dog":{"dogName":"dawang"}}
        pvs.add("dog.dogName", "dawang");
        binder.bind(pvs);
        System.out.println(JSON.toJSONString(person));
    }

    @Test
    public void test1() {        //{"name":["dmz0","dmz1"]}
        pvs.add("name[0]", "dmz0");
        pvs.add("name[1]", "dmz1");
        binder.bind(pvs);
        System.out.println(JSON.toJSONString(person));
    }


    @Test
    public void test2() {        //{"catNames":["dmz0","dmz1"]}
        pvs.add("catNames[0]", "dmz0");
        pvs.add("catNames[1]", "dmz1");
        binder.bind(pvs);
        System.out.println(JSON.toJSONString(person));
    }

    @Test
    public void test3() {        //{"computeMaps":{"zhangsan":"dmz0","wangwu":"dmz1"}}
        pvs.add("computeMaps[zhangsan]", "dmz0");
        binder.bind(pvs);
        System.out.println(JSON.toJSONString(person));
    }

    @Test
    public void test3_1() {
        pvs.add("userInfos[zhangsan][1]", "2.0");
        binder.bind(pvs);
        System.out.println(JSON.toJSONString(person));
    }

    @Test
    public void test3_2() {
        pvs.add("logs[zhangsan][1][2]", "3");
        binder.bind(pvs);
        System.out.println(JSON.toJSONString(person));
    }

    @Test
    public void test4() {        //{"shoesList":[{"brand":"耐克"},{"color":"红色"}]}
        pvs.add("shoesList[0].brand", "耐克");
        pvs.add("shoesList[1].color", "红色");
        binder.bind(pvs);
        System.out.println(JSON.toJSONString(person));
    }


    @Test
    public void test5() {
        String [][] c = {{"a"}};
        pvs.add("bs[0][0]", c);
        binder.bind(pvs);
        System.out.println(JSON.toJSONString(person));
    }

    @Test
    public void test6 (){
        String[][]b = new String[2][2];
        String [] c = {"a"};

        Array.set(b, 1, c);
    }

    @Test
    public void test7() {
        String [][][] c = {{{"a"}}};
        pvs.add("cs[0][0][0]", c);
        binder.bind(pvs);
        System.out.println(JSON.toJSONString(person));
    }

}

