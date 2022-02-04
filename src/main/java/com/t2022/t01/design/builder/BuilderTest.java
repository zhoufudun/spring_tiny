package com.t2022.t01.design.builder;

public class BuilderTest {

    public static void main(String[] args) {
        ProductBuilder specialConcreteProductBuilder = new SpecialConcreteProductBuilde();
        Director director = new Director(specialConcreteProductBuilder);
        Product product = director.makeProduct("productNamexxx","companyNamexxx","part1","part2","part3","part4");
        System.out.println(product);
    }
}
