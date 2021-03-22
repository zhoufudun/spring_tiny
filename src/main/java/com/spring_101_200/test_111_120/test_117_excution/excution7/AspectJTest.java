package com.spring_101_200.test_111_120.test_117_excution.excution7;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {

    //7.com.spring_1_100 包及所有子包下UserService前缀类型的的以test开头的只有一个参数类型为java.util.Date的方法，
    // 注意该匹配是根据方法签名的参数类型进行匹配的，而不是根据执行时传入的参数类型决定的如定义方法：public void test(Object obj);
    // 即使执行时传入java.util.Date，也不会匹配的；
    @Before("execution(* com.spring_101_200..UserServi*.test*(java.util.Date))")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

}
