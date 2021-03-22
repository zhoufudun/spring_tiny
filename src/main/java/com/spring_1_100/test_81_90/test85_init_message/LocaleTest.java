package com.spring_1_100.test_81_90.test85_init_message;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleTest {

    public static void main(String[] args) {
        Locale locale = new Locale("en","US");
        NumberFormat currFmt = NumberFormat.getCurrencyInstance(locale);
        double amt = 123456.78;
        System.out.println(currFmt.format(amt));
    }
}
