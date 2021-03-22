package com.spring_101_200.test_111_120.test_113_conversion.spel;

import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;

public class MyBeanResolver implements BeanResolver {

    @Override
    public Object resolve(EvaluationContext context, String beanName) throws AccessException {
        return new Inventor();
    }
}
