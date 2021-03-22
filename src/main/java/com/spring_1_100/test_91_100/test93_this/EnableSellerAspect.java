package com.spring_1_100.test_91_100.test93_this;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {

    @DeclareParents(value = "com.spring_1_100.test_91_100.test93_this.NaiveWaiter",defaultImpl = SmartSeller.class)
    public  Seller seller;


}
