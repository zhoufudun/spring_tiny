package com.spring_1_100.test_81_90.test85_init_message;

import sun.security.util.AuthResources_it;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormateTest {

    public static void main(String[] args) {
        Locale locale = new Locale("en","US");
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM,locale);
        System.out.println(dateFormat.format(date));
    }
}
