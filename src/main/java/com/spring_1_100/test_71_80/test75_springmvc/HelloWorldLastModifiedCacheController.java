package com.spring_1_100.test_71_80.test75_springmvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldLastModifiedCacheController extends AbstractController implements LastModified {
    private long lastModified;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(" cache modified 请求");
        response.getWriter().write("<a href=''>this</a>");
        return null;
    }

    @Override
    public long getLastModified(HttpServletRequest request) {
        if(lastModified == 0l){
            // 第一次或者逻辑变化的时候，应该重新的返回内容最新的修改时间戳
            lastModified = System.currentTimeMillis();
        }
        return lastModified;
    }
}
