package com.spring_101_200.test_191_200.test_197_directFieldAccessor;


import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IWhere {
    String column() default "";

    String value() default "";

    String defaultValue() default "";

    String desc() default "";
}
