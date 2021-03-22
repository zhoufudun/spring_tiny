package com.spring_101_200.test_111_120.test_116_aliasfor;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Deprecated //
public @interface MyComponentScan {

    @AliasFor(value = "value", annotation = ComponentScan.class)
    String[] value() default {};

}
