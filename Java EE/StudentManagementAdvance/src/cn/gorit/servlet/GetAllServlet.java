package cn.gorit.servlet;

import cn.gorit.entity.Student;
import cn.gorit.util.BaseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Style;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// 分页显示数据
@WebServlet("/GetAllServlet")
public class GetAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        BaseDao db = new BaseDao();
        HttpSession session = request.getSession();
        int pageNo = 1;
        String str = request.getParameter("pageNo");
        System.out.println(str);
        str.replace("\"", "");



        if (str != null) {
            pageNo = Integer.valueOf(str);
        }

        int pageSize = 5; // 每页固定的展示数目
        int count = 0; // 求出最大条数
        try {
            PreparedStatement ps = db.getConnect("select count(*) from student");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            db.closed(ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        System.out.println(count);

        //每页显示的条数
        int pageCount = 0;
        if (count%pageSize == 0) {
            pageCount = count/pageSize;
            System.out.println(pageCount);
        } else {
            pageCount = count/pageSize+1;
            System.out.println(pageCount);
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Student> list = new ArrayList<Student>();
        try {
            ps = db.getConnect("select * from student limit ?,?");
            ps.setInt(1,pageSize*(pageNo-1));
            ps.setInt(2,pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Student(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
            }
            db.closed(ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        session.setAttribute("pageNo",pageNo);
        session.setAttribute("pageCount",pageCount);
        session.setAttribute("list",list);
        response.sendRedirect("second.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
