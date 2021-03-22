package com.spring_101_200.test_181_190.test_189_spring_mvc_validator;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value="/login")
    public String login( @Valid User user, BindingResult result) {
        System.out.println(JSON.toJSONString(user));
        String page = "success";
        if(result.hasErrors()){
            page = "login";
            List<ObjectError> list = result.getAllErrors();
            for(ObjectError objectError : list){
                System.out.println("============" + objectError.getDefaultMessage());
            }
        } else{
            page = "success";
        }
        return page;
    }


}
