package com.spring_101_200.test_181_190.test_185_spring_mvc;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AttrValue {

    String[] value() default "";

    String desc() default "";

    String type() default "String";

    int need() default 0;

}