package com.itcast.web.servlet;

import com.itcast.domain.PageBean;
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
 * @author CLAY
 * @version 1.1
 * @data 2020/1/7 23:12
 */
@WebServlet("/FindUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String currentPage = request.getParameter("currentPage");
        String rowS = request.getParameter("rows");
        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if(rowS == null || "".equals(rowS)){
            rowS = "5";
        }
        UserService us = new UserServiceImpl();
        PageBean<User> pb = us.findUserByPage(currentPage,rowS);
        request.setAttribute("pb",pb);
        System.out.println(pb);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
//        response.sendRedirect(request.getContextPath()+"/list.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
