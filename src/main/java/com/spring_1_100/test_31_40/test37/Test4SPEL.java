package com.spring_1_100.test_31_40.test37;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test4SPEL {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        //加法运算
        Integer iResult = parser.parseExpression("2+3-1").getValue(Integer.class);
        System.out.println("加法运算：" + iResult);
    }
}
