package com.itcast.web.servlet;

import com.itcast.domain.LoginUser;
import com.itcast.service.UserService;
import com.itcast.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author:CLAY
 * @Date: 2020/1/8
 * @Time: 13:32
 * @Version: 1.1
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        LoginUser loginUser = new LoginUser();
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService us = new UserServiceImpl();
        String checkcode = request.getParameter("checkcode");
        String CHECKCODE_SERVER = (String)request.getSession().getAttribute("CHECKCODE_SERVER");
        if (CHECKCODE_SERVER.equals(checkcode)){
            Boolean login = us.login(loginUser);
            if (login){
                HttpSession session = request.getSession();
                session.setAttribute("username",loginUser.getUsername());
                request.setAttribute("username",loginUser.getUsername());
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }else {
                request.setAttribute("login_msg","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("login_msg","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
