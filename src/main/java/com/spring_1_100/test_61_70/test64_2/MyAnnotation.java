package com.spring_1_100.test_61_70.test64_2;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Documented
public @interface MyAnnotation {
    String value() default "";

}