package cn.gorit.servlet;

import cn.gorit.entity.ShopcartAndProductDetail;
import cn.gorit.entity.User;
import cn.gorit.util.BaseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowAllServlet")
public class ShowAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询该用户的所有购物车信息
        HttpSession session=request.getSession();
        BaseDao db = new BaseDao();
        List<ShopcartAndProductDetail> list= new ArrayList<ShopcartAndProductDetail>();
        try {
            PreparedStatement ps= db.getConnect("select s.shop_no, p.product_name ,p.price, s.num from product p,shopcart s where p.pid=s.pid and s.uid=?;");
            User u=(User) session.getAttribute("loginUser");
            int uid=u.getId();
            ps.setInt(1,uid);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
//                System.out.println(rs.getInt(1)+"\t"+ rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getInt(4));
                list.add(new ShopcartAndProductDetail(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
            }
            db.closed(ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("slist1",list);
        response.sendRedirect("ShopCart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
