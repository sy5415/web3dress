package com.sy.servlet;

import com.sy.bean.User;
import com.sy.service.UserService;
import com.sy.service.impl.UserServiceImpl;

import javax.jws.Oneway;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=new User(null,username,password,null);
        try {
            User loginUser=userService.doLogin(user);
            response.sendRedirect(request.getContextPath()+"/pages/user/login_success.html");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath()+"/pages/user/login.html");
        }
        System.out.println(username+password);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
