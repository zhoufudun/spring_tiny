package com.spring_101_200.test_191_200.test_194_spring_mvc_message_converters;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {


    //在 postMan中，选择 Body ，下面选择 raw ， Text(text/plain) ，在内容中输入winzip|123456|13818888888
    @RequestMapping(value = "/message")
    public String account(@RequestBody  User user) {

        System.out.println(JSON.toJSONString(user));
        return "haha";
    }

}
