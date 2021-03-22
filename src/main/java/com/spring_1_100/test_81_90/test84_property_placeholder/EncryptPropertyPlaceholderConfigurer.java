package com.spring_1_100.test_81_90.test84_property_placeholder;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {


    @Override
    protected String convertProperty(String propertyName, String propertyValue) {

        return super.convertProperty(propertyName, propertyValue + "xxxxxxxx");
    }
}
