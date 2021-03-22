package com.spring_101_200.test_111_120.test_117_excution.excution20;

import org.aspectj.lang.annotation.Pointcut;

public class AspectjParent  extends AspectjParentParent{

    @Pointcut("execution(* com..MySerxx*.*(..))")                                                    //com 包及所有子包下UserService接口中的任何无参方法
    public void test1() {

    }

}
