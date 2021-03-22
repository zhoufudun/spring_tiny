package com.spring_1_100.test_91_100.test91_introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJIntroductionAnnotationAdvice {
    @DeclareParents(value = "com.spring_1_100.test_91_100.test91_introduction.*", defaultImpl = DeclareParentProxyImpl.class)
    private IDeclareParentProxy iDeclareParentProxy;
}