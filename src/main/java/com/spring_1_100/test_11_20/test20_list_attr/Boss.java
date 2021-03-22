package com.spring_1_100.test_11_20.test20_list_attr;

import lombok.Data;

import java.util.List;

@Data
public class Boss {
    // 这两个是一样的，如果属性不存在，直接 new
    private List<String> favorites = null;//= new ArrayList<>();
    //private List<String> favorites = new ArrayList<>();

    private List<String> favoriteList1 ;


}
