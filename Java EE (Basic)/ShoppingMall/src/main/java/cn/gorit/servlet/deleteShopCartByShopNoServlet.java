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

@WebServlet("/deleteShopCartByShopNoServlet")
public class deleteShopCartByShopNoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int shop_id = Integer.valueOf(request.getParameter("ShopNO"));
        System.out.println(shop_id);
        BaseDao db = new BaseDao();
        PreparedStatement ps = null;
        try {
            ps = db.getConnect("delete from shopcart where shop_no = ?");
            ps.setInt(1,shop_id);
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("É¾³ý³É¹¦");
                response.getWriter().print("1");
            } else {
                response.getWriter().print("2");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
