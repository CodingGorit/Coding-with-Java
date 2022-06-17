package com.example.controller;

import com.example.dao.UserDao;
import com.example.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @version v1.0
 * @Classname LoginServlet
 * @Description TODO
 * @Author CodingGorit
 * @Created on 2022/6/16 0:01
 * @IDLE IntelliJ IDEA
 **/
@WebServlet("/CheckLoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        UserDao dao = new UserDao();
        dao.initData();

        User user = dao.getUserByUsername(username);
        session.setAttribute("aaa", "aaa");
        // 前面已经检查过用户的合法性了
        if (user.getPassword().equals(password)) {
            session.setAttribute("loginUser", user);
            response.sendRedirect("index.jsp");
        } else {
            session.setAttribute("err", "您的密码错误");
            response.sendRedirect("login.jsp");
        }
        // 校验账号密码

//        request.setAttribute("err", "登录失败");
//        request.getRequestDispatcher("login.jsp").forward(request, response);

//        response.sendRedirect("index.jsp");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
