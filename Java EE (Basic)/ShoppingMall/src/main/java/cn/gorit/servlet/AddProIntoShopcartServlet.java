package cn.gorit.servlet;

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

@WebServlet("/AddProIntoShopcartServlet")
public class AddProIntoShopcartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");

        // 检查登录状态
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") != null) {
            System.out.println("进来了");
            // 登录过了，将商品加入到购物车
            int pid = Integer.valueOf(request.getParameter("pid")); // 得到货物的 id，然后插入数据库
            User u = (User) session.getAttribute("loginUser");
            int uid = u.getId();
            BaseDao db=new BaseDao();
             try {
                // 进来就判断，货物 id 是否重复，如果重复，就更新
                PreparedStatement ps1 = db.getConnect("select num from shopcart where pid = ?");
                ps1.setInt(1,pid);
                ResultSet rs = ps1.executeQuery();
                if (!rs.next()) { //说明有这条记录
                    // 没有记录，则插入一个货物
                    System.out.println("我进来了插入数据");
                    PreparedStatement ps=db.getConnect("insert into shopcart (pid,uid,num) values (?,?,?)");
                    ps.setInt(1, pid);
                    ps.setInt(2, uid);
                    ps.setInt(3, 1);
                    ps.executeUpdate();
                } else {
                    System.out.println("有记录，累加数据");
                    int num = rs.getInt(1);
                    PreparedStatement ps2 = db.getConnect("update shopcart set num = num+1 where uid = ? and pid = ?");
                    ps2.setInt(1,uid);
                    ps2.setInt(2,pid);
                    ps2.executeUpdate();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
           // 显示购物车页面
           response.sendRedirect("ShowAllServlet");
        } else {
            session.setAttribute("msg","请先登录，再加入购物车");
            response.sendRedirect("login.jsp");
        }

    }
}
