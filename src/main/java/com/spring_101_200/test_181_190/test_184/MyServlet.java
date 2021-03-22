package com.spring_101_200.test_181_190.test_184;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    public void init() {
        System.out.println("this is init method ");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        handleLogic(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        handleLogic(request, response);
    }

    private void handleLogic(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("handle myLogic ");
        ServletContext sc = getServletContext();
        RequestDispatcher rd = null;
        rd = sc.getRequestDispatcher("/index.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
