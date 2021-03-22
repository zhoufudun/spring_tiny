package com.spring_101_200.test_181_190.test_188_spring_mvc_conversion_service;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {


    //http://localhost:8080/test/query.htm?user=zhangsan:lisi
    @RequestMapping("query")
    public String query(User user ){
        System.out.println(JSON.toJSONString(user));


        return "userlist";
    }

}
