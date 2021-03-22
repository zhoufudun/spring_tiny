package com.spring_101_200.test_141_150.test_145_mybatis_cachenamespaceref_xml;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.builder.BuilderException;

import java.util.HashMap;

public class Test145_exp {

    public static HashMap<String, String> r = new HashMap<>();


    public static void main(String[] args) {
        parse("(a?1:2),userName:VARCHAR,javaType=java.util.Long,numericScale=2,resultMap=xxx,typeHandler=MyTypeHandler,jdbcTypeName=long");

        System.out.println(JSON.toJSONString(r));
    }

    public static void parse(String expression) {
        int p = skipWS(expression, 0);
        if (expression.charAt(p) == '(') {
            expression(expression, p + 1);
        } else {
            property(expression, p);
        }
    }

    public static void expression(String expression, int left) {
        int match = 1;
        int right = left + 1;
        while (match > 0) {
            if (expression.charAt(right) == ')') {
                match--;
            } else if (expression.charAt(right) == '(') {
                match++;
            }
            right++;
        }
        r.put("expression", expression.substring(left, right - 1));
        jdbcTypeOpt(expression, right);
    }

    public static void property(String expression, int left) {
        if (left < expression.length()) {
            int right = skipUntil(expression, left, ",:");
            r.put("property", trimmedStr(expression, left, right));
            jdbcTypeOpt(expression, right);
        }
    }

    public static int skipWS(String expression, int p) {
        for (int i = p; i < expression.length(); i++) {
            if (expression.charAt(i) > 0x20) {
                return i;
            }
        }
        return expression.length();
    }

    public static int skipUntil(String expression, int p, final String endChars) {
        for (int i = p; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (endChars.indexOf(c) > -1) {
                return i;
            }
        }
        return expression.length();
    }

    public static void jdbcTypeOpt(String expression, int p) {
        p = skipWS(expression, p);
        if (p < expression.length()) {
            if (expression.charAt(p) == ':') {
                jdbcType(expression, p + 1);
            } else if (expression.charAt(p) == ',') {
                option(expression, p + 1);
            } else {
                throw new BuilderException("Parsing error in {" + new String(expression) + "} in position " + p);
            }
        }
    }

    public static void jdbcType(String expression, int p) {
        int left = skipWS(expression, p);
        int right = skipUntil(expression, left, ",");
        if (right > left) {
            r.put("jdbcType", trimmedStr(expression, left, right));
        } else {
            throw new BuilderException("Parsing error in {" + new String(expression) + "} in position " + p);
        }
        option(expression, right + 1);
    }

    public static void option(String expression, int p) {
        int left = skipWS(expression, p);
        if (left < expression.length()) {
            int right = skipUntil(expression, left, "=");
            String name = trimmedStr(expression, left, right);
            left = right + 1;
            right = skipUntil(expression, left, ",");
            String value = trimmedStr(expression, left, right);
            r.put(name, value);
            option(expression, right + 1);
        }
    }

    public static String trimmedStr(String str, int start, int end) {
        while (str.charAt(start) <= 0x20) {
            start++;
        }
        while (str.charAt(end - 1) <= 0x20) {
            end--;
        }
        return start >= end ? "" : str.substring(start, end);
    }
}
