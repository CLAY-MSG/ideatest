package com.itcast.web.servlet;

import com.itcast.domain.User;
import com.itcast.service.UserService;
import com.itcast.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:CLAY
 * @Date: 2020/1/8
 * @Time: 11:15
 * @Version: 1.1
 */
@WebServlet("/FindUserByIdServlet")
public class FindUserByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");
        request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        int userID = Integer.parseInt(userId);
        UserService us = new UserServiceImpl();
        User user = us.findUserById(userID);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/update.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
