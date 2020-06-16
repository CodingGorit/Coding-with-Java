package cn.gorit.servlet;

import cn.gorit.util.BaseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/updateProductCountServlet")
public class updateProductCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int shop_id = Integer.valueOf(request.getParameter("ShopNO"));
        int num = Integer.valueOf(request.getParameter("num"));
        System.out.println("shop_id"+shop_id);

        BaseDao db = new BaseDao();
        try {
            PreparedStatement ps = db.getConnect("update shopcart set num=? where shop_no = ?");
            ps.setInt(1,num);
            ps.setInt(2,shop_id);
            int res = ps.executeUpdate();
            if ( res > 0) {
                System.out.println("ÐÞ¸Ä³É¹¦");
                response.setCharacterEncoding("utf-8");
                response.getWriter().print("1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
