package com.spring_101_200.test_111_120.test_114_conversion2;

import org.apache.tools.ant.util.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String arg0) {
         try {
              SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              return simpleDateFormat.parse(arg0);
         } catch (ParseException e) {
              e.printStackTrace();
         }
         return null;
    }
}