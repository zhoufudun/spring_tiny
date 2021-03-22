package com.spring_1_100.test_21_30.test23_set_attr;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class Boss {
    private List<String> favorites = null;

    private Set<String> setfavorites = null;

    private Set favoriteSet1;
}
