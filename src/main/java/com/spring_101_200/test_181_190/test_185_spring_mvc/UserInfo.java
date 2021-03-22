package com.spring_101_200.test_181_190.test_185_spring_mvc;

import lombok.Data;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
public class UserInfo implements Serializable {
    private int age;
    private String desc;


}
