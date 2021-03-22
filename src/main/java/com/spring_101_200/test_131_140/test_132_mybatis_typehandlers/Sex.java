package com.spring_101_200.test_131_140.test_132_mybatis_typehandlers;

import lombok.ToString;

import javax.swing.border.CompoundBorder;

public enum Sex {
    MALE(1, "男"),
    FEMALE(2, "女");
    private int id;
    private String name;

    private Sex(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Sex{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
