package cn.gorit.servlet;

import cn.gorit.entity.Student;
import cn.gorit.util.BaseDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// ajax 实现分页逻辑
@WebServlet("/GetStuServlet")
public class GetStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        BaseDao db = new BaseDao();
        int pageNo = 1; // 查询页
        String str = request.getParameter("pageNo");
        if (str != null) {
            pageNo = Integer.valueOf(str);
        }
        int pageSize = 5; // 默认显示5条数据
        int count = 0; // 得到总条数
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

        int pageCount = 0; //每页要展示的数据
        if (count%pageSize == 0) {
            pageCount = count/pageSize;
        } else {
            pageCount = count/pageSize+1;
        }

        ArrayList<Student> list = new ArrayList<Student>();
        try {
            PreparedStatement ps = db.getConnect("select * from student limit ?,?");
            ps.setInt(1,pageSize*(pageNo-1));
            ps.setInt(2,pageSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Student(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
            }
            db.closed(ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
//        session.setAttribute("list",list);
        session.setAttribute("pageNo",pageNo);
        session.setAttribute("pageCount",pageCount);
        JSONArray js = JSONArray.fromObject(list);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(js.toString());
        response.sendRedirect("Student.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
