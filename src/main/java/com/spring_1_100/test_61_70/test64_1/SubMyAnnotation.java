package com.spring_1_100.test_61_70.test64_1;


import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@MyAnnotation
public @interface SubMyAnnotation {

    @AliasFor(annotation = ParentMyAnnotation.class,attribute = "aaaa")
    String iiii() default "";

    @AliasFor(annotation = MyAnnotation.class, attribute = "yyyy")
    String jjjj() default "";

}
