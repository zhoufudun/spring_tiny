package com.spring_101_200.test_191_200.test_196_spring_mvc_ignore_default_model_on_redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {


    //用户登录
    @RequestMapping(value = "/goLogin", method = RequestMethod.GET)
    public String goLogin(User user, Map<Object, Object> map, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("登录1");
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        //按用户名密码查询
        if (true) {
            System.out.println("登录2");
            map.put("username", "zhangsan");
            map.put("password", "lisi");
            System.out.println("登录成功");
            return "redirect:index";// 重定向
        } else {
            return "error";
        }

    }


    //http://localhost:8080/test/index?username=zhangsan&password=lisi
    @RequestMapping(value = "index")
    public String index() {
        return "index";
    }


}
