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
import java.util.Map;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/1/8 0:16
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User newUser = new User();
        try {
            BeanUtils.populate(newUser,parameterMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        UserService us = new UserServiceImpl();
        us.addUser(newUser);
        request.getRequestDispatcher("/UserListServlet").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
