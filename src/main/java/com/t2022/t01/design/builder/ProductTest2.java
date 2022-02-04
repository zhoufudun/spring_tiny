package com.t2022.t01.design.builder;

public class ProductTest2 {

    public static void main(String[] args) {
        Product.Builder builder = new Product.Builder().productName("xxx").companyName("xxxxxx").part1("1").part2("2").part3("3").part4("4");

        builder.part3("part3");
        Product product = builder.build();
        System.out.println(product);
    }
}
