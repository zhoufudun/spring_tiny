package com.spring_101_200.test_181_190.test_185_spring_mvc.bindtest;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Person {
    // 省略getter/setter方法
    private List<String> name;
    private Dog dog;
    private Integer age;
    private String[] catNames;
    private Map<String, Object> computeMaps;
    private List<Shoes> shoesList;
    private String bs[][];
    private String cs[][][];

    private Map<String, Map<Integer,Double>> userInfos;

    private Map<String, Map<Integer,Map<Long,Double>>> logs;

}