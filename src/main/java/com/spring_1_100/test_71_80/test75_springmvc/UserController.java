package com.spring_1_100.test_71_80.test75_springmvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

public class UserController extends AbstractController {


    //http://localhost:8080/userlist.htm
    @Override
    protected ModelAndView handleRequestInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        List<User> userList = new ArrayList<User>();
        User userA = new User("zhangsan",27);
        User userB = new User("lisi",28);
        userList.add(userA);
        userList.add(userB);
        String myData =(String) getServletContext().getAttribute("myData");

        System.out.println("===========" + myData);
        int i = 1 ;
        int j = 0 ;
        //int c = i / j ;
        return new ModelAndView("userlist","users",userList);

    }
}
