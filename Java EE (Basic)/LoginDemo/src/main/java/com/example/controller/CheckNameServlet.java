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
 * 基于 ajax 校验用户名
 */
@WebServlet("/CheckNameServlet")
public class CheckNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        UserDao dao = new UserDao();
        dao.initData();
        User user = dao.getUserByUsername(username);
        if (user == null) {
            response.getWriter().print(0);
        } else {
            response.getWriter().print(1);
        }
//        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
