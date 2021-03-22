package com.spring_101_200.test_191_200.test_193_spring_mvc_argument_resolvers;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping(value = "/args", method = RequestMethod.GET)
    public String account(User user) {

        System.out.println(JSON.toJSONString(user));
        return "haha";
    }

}
