package com.spring_1_100.test_91_100.test94_target;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {

    @DeclareParents(value = "com.spring_1_100.test_91_100.test94_target.NaiveWaiter",defaultImpl = SmartSeller.class)
    public static Seller seller;


}
