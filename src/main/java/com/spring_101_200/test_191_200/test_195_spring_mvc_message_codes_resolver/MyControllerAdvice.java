package com.spring_101_200.test_191_200.test_195_spring_mvc_message_codes_resolver;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(value = org.springframework.validation.BindException.class)
    public void exceptionHandler(BindException e, HttpServletResponse response) throws IOException {
        StringBuffer msg = new StringBuffer();
        e.getFieldErrors().forEach(item -> {
            msg.append("对象：【").append(item.getObjectName()).append("】");
            msg.append("  字段： 【").append(item.getField()).append("】 ");
            msg.append("  参数绑定错误：");
            msg.append("  错误值为: 【").append(item.getRejectedValue()).append("】 ");
        });
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        System.out.println("=================" + msg.toString());
        out.write(msg.toString());
        out.flush();
        out.close();
    }


}