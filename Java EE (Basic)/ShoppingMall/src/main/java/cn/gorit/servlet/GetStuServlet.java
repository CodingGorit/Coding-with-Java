package cn.gorit.servlet;

import cn.gorit.entity.Student;
import cn.gorit.util.BaseDao;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GetStuServlet")
public class GetStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("sname");
        System.out.println(name);
        BaseDao db = new BaseDao();
        List<Student> list = new ArrayList<Student>();
        try {
            PreparedStatement ps = db.getConnect("select * from student where sname like ?");
            ps.setString(1,"%"+name+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
                list.add(new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
            }
            db.closed(ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.toString());
        // 集合转换为一个方便输出并且 js 也可以编译的格式
        // 字符串不需要转为 json 格式 对象需要转为 json 格式
        JSONArray ja = JSON.parseArray(String.valueOf(list));
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(ja.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
