package com.spring_101_200.test_191_200.test_195_spring_mvc_message_codes_resolver;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/login")
    public String login(Model model, @Valid User user, BindingResult result) {
        System.out.println(JSON.toJSONString(user));
        result.rejectValue("mobile", "mobile", "mobile is empty.");
        String page = "success";
        if (result.hasErrors()) {
            page = "login";
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError objectError : list) {
                System.out.println(objectError.getObjectName() + "|" + objectError.getCode() + "============" + objectError.getDefaultMessage());
            }
            model.addAttribute("errors", list);
        } else {
            page = "success";
        }
        return page;
    }


    @RequestMapping(value = "/login2")
    public String login2(Model model, @Valid User user, BindingResult result) {
        System.out.println(JSON.toJSONString(user));
        result.reject("testFlag", "kwkw ");
        String page = "success";
        if (result.hasErrors()) {
            page = "login";
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError objectError : list) {
                System.out.println(objectError.getObjectName() + "|" + objectError.getCode() + "============" + objectError.getDefaultMessage());
            }
            model.addAttribute("errors", list);
        } else {
            page = "success";
        }
        return page;
    }


    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveUser(@Valid User user, BindingResult bindingResult) {
        // 如果在绑定的时候，发生错误，那么错误信息就会保存在BindingResult 这里面，从里里面可以获取具体信息
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(item -> {
                System.out.println(item.getObjectName());
                System.out.println(item.getArguments());
                System.out.println(item.getDefaultMessage());
                System.out.println(item.getCode());
            });
        }
        return "success";
    }


    @ResponseBody
    @RequestMapping(value = "/save2", method = RequestMethod.GET)
    public String save2(@Valid User user) {
        return "success";
    }


}
