package com.spring_101_200.test_191_200.test_191_spring_mvc_content_negotiation;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {


    //https://blog.csdn.net/he90227/article/details/51537800
    @RequestMapping(value="/accounts", method= RequestMethod.GET,produces={"application/xml", "application/json"},consumes = {})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Account> list() {


        List<Account> accounts = new ArrayList<>();

        Account account1 = new Account();
        account1.setUsername("zhangsan");
        account1.setPassword("899832");
        accounts.add(account1);


        Account account2 = new Account();
        account2.setUsername("zhangsan");
        account2.setPassword("899832");
        accounts.add(account2);
        System.out.println("json:" + JSON.toJSONString(accounts));
        return accounts;
    }







    @RequestMapping(value="/account", method= RequestMethod.GET,produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Account account() {


        Account account1 = new Account();
        account1.setUsername("zhangsan");
        account1.setPassword("899832");

        return account1;
    }
}
