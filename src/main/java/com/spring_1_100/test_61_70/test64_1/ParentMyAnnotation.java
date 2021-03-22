package com.spring_1_100.test_61_70.test64_1;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author sandy
 * @AliasFor 用法：<br>
 * <li>用到注解 属性上，表示两个属性互相为别名，互相为别名的属性值必须相同，若设置成不同，则会报错</li>
 * <li>注解是可以继承的，但是注解是不能继承父注解的属性的,也就是说,我在类扫描的时候,拿到的注解的属性值,依然是父注解的属性值,而不是你定义的注解的属性值<br>
 * 所以此时可以在子注解对应的属性上加上@AliasFor<br>
 * <pre><code>
 *
 * </code></pre>
 * </li>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface ParentMyAnnotation {
    @AliasFor(value = "bbbb")
    String aaaa() default "";

    @AliasFor(value = "aaaa")
    String bbbb() default "";
}