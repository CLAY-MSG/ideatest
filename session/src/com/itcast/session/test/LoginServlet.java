package com.itcast.session.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object checkCode_session = request.getSession().getAttribute("checkCode_session");
        String checkCode = request.getParameter("checkCode");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("root") && "root".equals(password)){
            if (checkCode_session.equals(checkCode)){
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else {
                response.sendRedirect(request.getContextPath()+"/login.jsp");
                response.getWriter().println("<script>window.alert('验证码错误')</script>");
            }
        }else {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            response.getWriter().println("<script>window.alert('密码错误')</script>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
