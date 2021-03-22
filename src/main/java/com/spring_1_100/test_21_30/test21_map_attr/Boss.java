package com.spring_1_100.test_21_30.test21_map_attr;

import lombok.Data;

import java.util.Map;

@Data
public class Boss {
    private Map jobs ;

    private Map<String,Integer> jobTimes;

    private Map emails1;
}
