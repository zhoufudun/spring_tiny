package com.t2022.t01.design.flyweight;

import lombok.Data;

@Data
public class Tree {

    private final String name;
    private final String data ;

    public Tree(String name, String data) {
        System.out.println("name :" + name + " tree created .");
        this.name = name;
        this.data = data;
    }



}
