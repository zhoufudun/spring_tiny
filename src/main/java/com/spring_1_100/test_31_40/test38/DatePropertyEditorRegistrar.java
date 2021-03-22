package com.spring_1_100.test_31_40.test38;

import com.utils.LogUtils;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar {


    public void registerCustomEditors(PropertyEditorRegistry registry) {
        LogUtils.all("registerCustomEditors");
        registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

}
