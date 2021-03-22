package com.spring_1_100.test_81_90.test83_property_editor;

import lombok.Data;

@Data
public class Boss {
    private String name;
    private Car car = new Car();

}
