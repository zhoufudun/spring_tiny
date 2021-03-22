package com.spring_1_100.test_1_10.test;


import org.springframework.util.CollectionUtils;

import java.util.*;

public class SpringTest1_3 {

    private static final String FOLDER_SEPARATOR = "/";

    private static final String WINDOWS_FOLDER_SEPARATOR = "\\";

    private static final String TOP_PATH = "..";

    private static final String CURRENT_PATH = ".";

    private static final char EXTENSION_SEPARATOR = '.';

    public static void main(String[] args) {
        String a = "f/../../a/b/c/../../spring_test3.xml";
        System.out.println(cleanPath(a));
    }


    public static String cleanPath(String path) {
        if (path == null) {
            return null;
        }
        // 将所有的 \\ 替换成 / ，window 中的路径可能以 \\ 分隔 ,mac 或者 linux 路径分隔一般以/ 来分隔
        String pathToUse = replace(path, WINDOWS_FOLDER_SEPARATOR, FOLDER_SEPARATOR);
        // 如果有像 classpath: ，file: 等，将前缀保留下来
        int prefixIndex = pathToUse.indexOf(":");
        String prefix = "";
        if (prefixIndex != -1) {
            // 如果字符串中包含 :
            prefix = pathToUse.substring(0, prefixIndex + 1);
            if (prefix.contains("/")) {
                // 如果前缀中包含 /
                prefix = "";
            }
            else {
                // 如果前缀中不包含 / ，则截取前缀保留，不做计算
                pathToUse = pathToUse.substring(prefixIndex + 1);
            }
        }

        if (pathToUse.startsWith(FOLDER_SEPARATOR)) {
            // 如果去除前缀 classpath: 还以 / 开头 ，classpath:/spring_1_100\config_1_10/spring_test1/./a/b/c/../../spring_test3.xml
            prefix = prefix + FOLDER_SEPARATOR;
            pathToUse = pathToUse.substring(1);
        }

        // 以 / 分隔 得到字符串数组
        String[] pathArray = delimitedListToStringArray(pathToUse, FOLDER_SEPARATOR);
        List<String> pathElements = new LinkedList<String>();
        int tops = 0;
        // 反序计算
        for (int i = pathArray.length - 1; i >= 0; i--) {
            String element = pathArray[i];
            // 如果pathArray[i] 是 . 则直接略过
            if (CURRENT_PATH.equals(element)) {

            }
            else if (TOP_PATH.equals(element)) {
                // 如果pathArray[i] 是 .. ，top ++
                tops++;
            }
            else {
                if (tops > 0) {
                    // 抵消掉路径 ,比如 config_1_10/spring_test1/./a/b/c/../../spring_test3.xml 当找到第一个.. ,top = 1
                    // 第二个 .. 时，top =2 ,当循环到 c 时，top = 2 ，让 top -- ，top = 1 ，抵消掉 c,
                    // 从后面向前查找，查找到第一个第二个.. 抵消掉 c ,第一个.. ，抵消掉 b .
                    tops--;
                }
                else {
                    // 如果没有.. 抵消，直接保存到集合中
                    pathElements.add(0, element);
                }
            }
        }
        // 如果 .. 没有被抵消完全，在集合开头加 上 ..
        // f/../../a/b/c/../../spring_test3.xml 解析成 ../a/spring_test3.xml
        for (int i = 0; i < tops; i++) {
            pathElements.add(0, TOP_PATH);
        }
        // 将之前的保留的前缀回到开头，同时对集合中的每个元素以 / 分隔
        return prefix + collectionToDelimitedString(pathElements, FOLDER_SEPARATOR);
    }
    public static String collectionToDelimitedString(Collection<?> coll, String delim) {
        return collectionToDelimitedString(coll, delim, "", "");
    }


    public static String collectionToDelimitedString(Collection<?> coll, String delim, String prefix, String suffix) {
        if (CollectionUtils.isEmpty(coll)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = coll.iterator();
        while (it.hasNext()) {
            sb.append(prefix).append(it.next()).append(suffix);
            if (it.hasNext()) {
                sb.append(delim);
            }
        }
        return sb.toString();
    }

    public static String[] delimitedListToStringArray(String str, String delimiter) {
        return delimitedListToStringArray(str, delimiter, null);
    }

    public static String[] delimitedListToStringArray(String str, String delimiter, String charsToDelete) {
        if (str == null) {
            return new String[0];
        }
        if (delimiter == null) {
            return new String[] {str};
        }
        List<String> result = new ArrayList<String>();
        if ("".equals(delimiter)) {
            for (int i = 0; i < str.length(); i++) {
                result.add(deleteAny(str.substring(i, i + 1), charsToDelete));
            }
        }
        else {
            int pos = 0;
            int delPos;
            while ((delPos = str.indexOf(delimiter, pos)) != -1) {
                result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
                pos = delPos + delimiter.length();
            }
            if (str.length() > 0 && pos <= str.length()) {

                result.add(deleteAny(str.substring(pos), charsToDelete));
            }
        }
        return toStringArray(result);
    }
    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }
        return collection.toArray(new String[collection.size()]);
    }




    public static String deleteAny(String inString, String charsToDelete) {
        if (!hasLength(inString) || !hasLength(charsToDelete)) {
            return inString;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inString.length(); i++) {
            char c = inString.charAt(i);
            if (charsToDelete.indexOf(c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }



    public static String replace(String inString, String oldPattern, String newPattern) {
        if (!hasLength(inString) || !hasLength(oldPattern) || newPattern == null) {
            return inString;
        }
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        int index = inString.indexOf(oldPattern);

        int patLen = oldPattern.length();
        while (index >= 0) {
            sb.append(inString.substring(pos, index));
            sb.append(newPattern);
            pos = index + patLen;
            index = inString.indexOf(oldPattern, pos);
        }
        sb.append(inString.substring(pos));

        return sb.toString();
    }

    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }



}



