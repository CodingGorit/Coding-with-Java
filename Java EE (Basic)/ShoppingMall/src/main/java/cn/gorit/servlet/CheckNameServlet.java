package cn.gorit.servlet;

import cn.gorit.util.BaseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// AJAX 验证用户名合法
@WebServlet("/CheckNameServlet")
public class CheckNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        String username = request.getParameter("username");
        System.out.println(username);
        BaseDao db = new BaseDao();
        PreparedStatement ps = null;
        boolean flag = false;
        try {
            ps = db.getConnect("select * from user where username = ?");
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // 查到数据就返回 true
                flag = true;
            }
            db.closed(ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().print(flag);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
