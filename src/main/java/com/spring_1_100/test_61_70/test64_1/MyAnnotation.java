package com.spring_1_100.test_61_70.test64_1;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@ParentMyAnnotation
public @interface MyAnnotation {

    @AliasFor(attribute = "aaaa", annotation = ParentMyAnnotation.class)
    String xxxx() default "";

    @AliasFor(attribute = "bbbb", annotation = ParentMyAnnotation.class)   //缺省指明继承的父注解的中的属性名称，则默认继承父注解中同名的属性名
    String yyyy() default "";

    @AliasFor(attribute = "bbbb", annotation = ParentMyAnnotation.class)   //缺省指明继承的父注解的中的属性名称，则默认继承父注解中同名的属性名
    String zzzz() default "";

}