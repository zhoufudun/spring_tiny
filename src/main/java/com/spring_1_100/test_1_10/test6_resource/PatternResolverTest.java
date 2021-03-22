package com.spring_1_100.test_1_10.test6_resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class PatternResolverTest {

    public static void main(String[] args) throws Exception{
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resources[] = resolver.getResources("classpath*:spring_1_100/**/*.xml");
        for(Resource resource:resources){
            System.out.println(resource.getFile().getName());
        }
    }
}
