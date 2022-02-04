package com.t2022.t01.design.builder;

public interface ProductBuilder {

    void builderProductName(String productName);

    void builderCompanyName(String companyName);


    void builderPart1(String part1);

    void builderPart2(String part2);

    void builderPart3(String part3);

    void builderPart4(String part4);

    Product build();

}
