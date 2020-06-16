package cn.gorit.servlet;

import cn.gorit.dao.StudentDao;
import cn.gorit.dao.impl.StudentDaoImpl;
import cn.gorit.entity.Student;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("删除学生的信息");
        StudentDao dao = new StudentDaoImpl();
        String stuID = request.getParameter("stuID");
        System.out.println(stuID);

        int res = 0;
        try {
            res = dao.deleteStudent(stuID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (res > 0) {
            System.out.println("删除成功");
            ArrayList<Student> list = new StudentDaoImpl().queryStudents();
            ServletContext application = request.getServletContext();
            application.setAttribute("list",list);
            response.sendRedirect("show.jsp");
        } else {
            System.out.println("删除失败");
            response.sendRedirect("show.jsp");
        }
    }
}
