package com.spring_1_100.test_1_10.test3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test1 {
    public final static Map<String, String> aliasMap = new ConcurrentHashMap<String, String>(16);

    public static void main(String[] args) {
        aliasMap.put("D", "C");
        aliasMap.put("C", "B");
        aliasMap.put("B", "A");
        boolean hasAlias = hasAlias("A", "D");
        if (hasAlias) {
            throw new IllegalStateException(" already");
        }
    }

    public static boolean hasAlias(String name, String alias) {
        System.out.println("00000000000       name = " + name + ",alias=" + alias);
        for (Map.Entry<String, String> entry : aliasMap.entrySet()) {
            String registeredName = entry.getValue();
            System.out.println("11111111111       registeredName = " + registeredName + ",name=" + name);
            if (registeredName.equals(name)) {
                String registeredAlias = entry.getKey();
                System.out.println("222222222222        registeredAlias = " + registeredAlias + ",alias=" + alias);
                return (registeredAlias.equals(alias) || hasAlias(registeredAlias, alias));
            }
        }
        return false;
    }


}