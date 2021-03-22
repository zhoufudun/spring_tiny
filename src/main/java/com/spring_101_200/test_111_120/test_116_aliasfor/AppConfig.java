package com.spring_101_200.test_111_120.test_116_aliasfor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@MyComponentScan(value = "com.spring_101_200.test_111_120.test_116_aliasfor")
@ComponentScan(value = "com.spring_101_200.test_111_120.test_116_aliasfor")
@EnableAspectJAutoProxy
public class AppConfig {
}