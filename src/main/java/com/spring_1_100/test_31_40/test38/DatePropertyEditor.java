
package com.spring_1_100.test_31_40.test38;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditor extends PropertyEditorSupport {
    private String format = "";

    public void setFormat(String format) {
        this.format = format;
    }

    public void setAsText(String arg0) throws IllegalArgumentException {
        System.out.println("arg0:" + arg0);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date d = sdf.parse(arg0);
            this.setValue(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




