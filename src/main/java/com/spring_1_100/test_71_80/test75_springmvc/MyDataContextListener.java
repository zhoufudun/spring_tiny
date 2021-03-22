package com.spring_1_100.test_71_80.test75_springmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.awt.*;

public class MyDataContextListener implements ServletContextListener {


    private ServletContext context;

    // 该方法在 ServletContext 启动后被调用，并准备好处理客户端请求
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.context = sce.getServletContext();
        //通过这里可以实现自己的逻辑并将结果记录在属性中
        context.setAttribute("myData","this is my Data");
    }


    //这个方法在ServletContext将要关闭的时候调用
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.context = null;
    }


}
