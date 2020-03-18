package com.itcast.web.servlet;

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
 * @Time: 16:06
 * @Version: 1.1
 */
@WebServlet("/DelSelectedUserServlet")
public class DelSelectedUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String[] selecteds = request.getParameterValues("selected");
        UserService us = new UserServiceImpl();
        us.delSelectedUser(selecteds);
        request.getRequestDispatcher("/UserListServlet").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
