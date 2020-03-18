package com.itcast.web.servlet;

import com.itcast.domain.User;
import com.itcast.service.UserService;
import com.itcast.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author:CLAY
 * @Date: 2020/1/8
 * @Time: 10:24
 * @Version: 1.1
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User updateUser = new User();

        try {
            BeanUtils.populate(updateUser,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService us = new UserServiceImpl();
        us.updateUser(updateUser);
        request.getRequestDispatcher("/UserListServlet").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
