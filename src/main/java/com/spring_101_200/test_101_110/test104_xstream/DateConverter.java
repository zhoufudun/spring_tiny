package com.spring_101_200.test_101_110.test104_xstream;


import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateConverter implements Converter {

    private Locale locale;

    public DateConverter() {
    }

    public DateConverter(Locale locale) {
        this.locale = locale;
    }


    // 实现该方法，判断要转换的类型
    public boolean canConvert(Class clazz) {
        return Date.class.isAssignableFrom(clazz);
    }

    // 实现该方法，编写java对象到XML转换逻辑
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date指定格式：yyyy-MM-dd HH:mm:ss:SSS
        writer.setValue(simpleDateFormat.format(value));
    }


    //实现该方法，编写XML到Java对象转换器
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//Date指定格式：yyyy-MM-dd HH:mm:ss:SSS

        try {
            return simpleDateFormat.parse(reader.getValue());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
