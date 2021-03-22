package com.spring_1_100.test_91_100.test91_introduction;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.spring_1_100.test_91_100.test91_introduction")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}