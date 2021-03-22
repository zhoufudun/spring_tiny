package com.spring_101_200.test_181_190.test_190_spring_mvc_path_matching;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("query")
    public String query(Long id) {
        System.out.println(id);
        return "userlist";
    }


}
