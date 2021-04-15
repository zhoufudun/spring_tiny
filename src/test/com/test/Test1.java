package com.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    public static Map<String, String> aliasMap = new HashMap<>();

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        aliasMap.put("a","beanA");
        aliasMap.put("b","a");
        aliasMap.put("c","a");

        retrieveAliases("beanA", list);
        System.out.println(JSON.toJSONString(list));
    }


    public static void retrieveAliases(String name, List<String> result) {
        for (Map.Entry<String, String> entry : aliasMap.entrySet()) {
            String registeredName = entry.getValue();
            if (registeredName.equals(name)) {
                String alias = entry.getKey();
                result.add(alias);
                retrieveAliases(alias, result);
            }
        }
    }
}
