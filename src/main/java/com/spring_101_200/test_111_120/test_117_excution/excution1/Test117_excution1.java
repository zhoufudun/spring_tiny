package com.spring_101_200.test_111_120.test_117_excution.excution1;

import com.spring_101_200.test_111_120.test_117_excution.excution0.XXXService;
import org.aspectj.weaver.BCException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test117_excution1 {


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_101_200/config_111_120/spring117_excution/spring_117_excution1.xml");
        MyService myService =  ac.getBean(MyService.class);
        myService.service();
    }


    @Test
    public void test() {
        String a = "execution(* com.\"spring_101_200\".*.*(..) && xxx)";
        makeTokenSource(a);
    }

    public static void makeTokenSource(String input) {
        char[] chars = input.toCharArray();
        int i = 0;
        List tokens = new ArrayList();

        while (i < chars.length) {
            char ch = chars[i++];
            switch (ch) {
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    continue;
                case '*':
                case '(':
                case ')':
                case '+':
                case '[':
                case ']':
                case ',':
                case '!':
                case ':':
                case '@':
                case '<':
                case '>':
                case '=':
                case '?':
                    tokens.add(MyBasicToken.makeOperator(makeString(ch), i - 1, i - 1));
                    continue;
                case '.':
                    if ((i + 2) <= chars.length) {
                        // could be '...'
                        char nextChar1 = chars[i];
                        char nextChar2 = chars[i + 1];
                        if (ch == nextChar1 && ch == nextChar2) {
                            // '...'
                            tokens.add(MyBasicToken.makeIdentifier("...", i - 1, i + 1));
                            i = i + 2;
                        } else {
                            tokens.add(MyBasicToken.makeOperator(makeString(ch), i - 1, i - 1));
                        }
                    } else {
                        tokens.add(MyBasicToken.makeOperator(makeString(ch), i - 1, i - 1));
                    }
                    continue;
                case '&':
                    if ((i + 1) <= chars.length && chars[i] != '&') {
                        tokens.add(MyBasicToken.makeOperator(makeString(ch), i - 1, i - 1));
                        continue;
                    }
                    // fall-through
                case '|':
                    if (i == chars.length) {
                        throw new BCException("bad " + ch);
                    }
                    char nextChar = chars[i++];
                    if (nextChar == ch) {
                        tokens.add(MyBasicToken.makeOperator(makeString(ch, 2), i - 2, i - 1));
                    } else {
                        throw new RuntimeException("bad " + ch);
                    }
                    continue;

                case '\"':
                    int start0 = i - 1;
                    while (i < chars.length && !(chars[i] == '\"')) i++;
                    i += 1;
                    tokens.add(MyBasicToken.makeLiteral(new String(chars, start0 + 1, i - start0 - 2), "string", start0, i - 1));
                    continue;
                default:
                    int start = i - 1;
                    while (i < chars.length && Character.isJavaIdentifierPart(chars[i])) {
                        i++;
                    }
                    tokens.add(MyBasicToken.makeIdentifier(new String(chars, start, i - start), start, i - 1));

            }
        }


        System.out.println(Arrays.toString(tokens.toArray()));


    }

    private static String makeString(char ch) {
        return Character.toString(ch);
    }

    private static String makeString(char ch, int count) {
        // slightly inefficient ;-)
        char[] chars = new char[count];
        for (int i = 0; i < count; i++) {
            chars[i] = ch;
        }
        return new String(chars);
    }
}
