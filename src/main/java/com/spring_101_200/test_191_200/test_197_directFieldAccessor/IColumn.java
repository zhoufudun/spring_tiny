package com.spring_101_200.test_191_200.test_197_directFieldAccessor;


import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IColumn {
    String tableName() default "";

    String column() default "";

    String mapping() default "";

    String defaultValue( ) default "";

    Class javaType() default String.class;

    String dateFormate() default "yyyy-MM-dd ";

    Class convertService() default Class.class;

    String desc () default  "";


}
