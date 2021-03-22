package com.spring_1_100.test_41_50.test50;

public class StuFactory {

    //动态创建类
    public Stu getDynamicStu(String stuId) {


        return new Stu(stuId);



    }

}