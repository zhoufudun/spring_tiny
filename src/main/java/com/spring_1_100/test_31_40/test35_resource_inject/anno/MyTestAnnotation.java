package com.spring_1_100.test_31_40.test35_resource_inject.anno;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@Mapping
@MyRequestAnnotation
public @interface MyTestAnnotation {
    String name() default "";

    @AliasFor("path")
    String[] value() default {};


    RequestMethod[] method() default {};

}
