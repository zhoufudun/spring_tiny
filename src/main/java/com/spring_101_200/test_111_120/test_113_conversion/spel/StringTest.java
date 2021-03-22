package com.spring_101_200.test_111_120.test_113_conversion.spel;

public class StringTest {

    public boolean isMember(String val) {
        return false;
    }

    public static String reverseString(String input) {
        StringBuilder backwards = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            backwards.append(input.charAt(input.length() - 1 - i));
        }
        return backwards.toString();
    }
}
