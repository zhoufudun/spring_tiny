package com.spring_101_200.test_111_120.test_112_env;

import com.alibaba.fastjson.JSON;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

public class UserController extends AbstractController {


    @Override
    protected ModelAndView handleRequestInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        List<User> userList = new ArrayList<User>();
        User userA = new User("zhangsan", 27);
        User userB = new User("lisi", 28);
        userList.add(userA);
        userList.add(userB);

        ServletContext servletContext = request.getSession().getServletContext();
        WebApplicationContext context = (WebApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        User user = (User) context.getBean("user");
        System.out.println(JSON.toJSONString(user));

        return new ModelAndView("userlist", "users", userList);
    }
}
