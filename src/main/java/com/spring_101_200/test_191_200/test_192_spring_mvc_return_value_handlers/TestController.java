package com.spring_101_200.test_191_200.test_192_spring_mvc_return_value_handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User user() {
        return new User();
    }
}
