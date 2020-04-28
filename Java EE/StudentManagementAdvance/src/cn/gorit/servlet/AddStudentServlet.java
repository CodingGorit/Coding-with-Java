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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        String addStuId = request.getParameter("addStuId");
        String addStuName = request.getParameter("addStuName");
        int addStuAge = Integer.parseInt(request.getParameter("addStuAge"));
        String addStuClazz = request.getParameter("addStuClazz"); // 插入整合的数据
        Student u = new Student(addStuId,addStuName,addStuAge,addStuClazz);

        String Grade = request.getParameter("Grade"); // 获取学生所在年级
        String studentClazz = request.getParameter("studentClazz"); // 获取学生所在班级
        System.out.println(u.toString());

        // 得到学生信息，插入数据库
        StudentDao dao = new StudentDaoImpl();
        int res = dao.addStudent(u,addStuClazz,Grade,studentClazz);
        // 添加完之后重新查询数据
        PrintWriter out = response.getWriter();
        if (res > 0) {
            System.out.println("添加成功");
            ArrayList<Student> list = new StudentDaoImpl().queryStudents();
            ServletContext application = request.getServletContext();
            application.setAttribute("list",list);
            response.sendRedirect("show.jsp");
        } else {
            System.out.println("添加失败");
            out.println("false");
            out.flush();
            out.close();
            response.sendRedirect("show.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
