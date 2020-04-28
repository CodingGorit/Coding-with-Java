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
import java.util.ArrayList;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("gbk");
        String addStuId = request.getParameter("addStuId");
        String addStuName = request.getParameter("addStuName");
        int addStuAge = Integer.parseInt(request.getParameter("addStuAge"));
        String addStuClazz = request.getParameter("addStuClazz"); // 插入整合的数据

        System.out.println(addStuId);
        System.out.println(addStuName);
        System.out.println(addStuAge);
        System.out.println(addStuClazz);
        System.out.println("我进来了！！！");

        Student stu = new Student(addStuId,addStuName,addStuAge,addStuClazz);

        String Grade = request.getParameter("Grade"); // 获取学生所在年级
        String studentClazz = request.getParameter("studentClazz"); // 获取学生所在班级

        // 数据库修改数据
        StudentDao dao = new StudentDaoImpl();
        int res = dao.updateStudent(stu,addStuClazz,Grade,studentClazz);
        ArrayList<Student> list = new StudentDaoImpl().queryStudents();
        ServletContext application = request.getServletContext();
        if (res > 0) {
            System.out.println("修改成功");
            application.setAttribute("list",list);
            response.sendRedirect("show.jsp");
        }
//        request.setAttribute("u",u);
//        request.getRequestDispatcher("edit_student.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
