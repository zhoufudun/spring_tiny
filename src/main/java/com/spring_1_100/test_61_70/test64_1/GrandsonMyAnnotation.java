package com.spring_1_100.test_61_70.test64_1;


import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@SubMyAnnotation
public @interface GrandsonMyAnnotation {

    @AliasFor(annotation = MyAnnotation.class,attribute = "zzzz")
    String mmmm() default "";

    @AliasFor(annotation = SubMyAnnotation.class, attribute = "iiii")
    String nnnn() default "";


}
